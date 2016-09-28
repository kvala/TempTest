package test;

public class RequestThrottler {
	/**
	 * The interval within we're ensuring max number of calls.
	 */
	private final long _interval;

	/**
	 * The maximum number of calls that can be made within the interval.
	 */
	private final int _maxCalls;

	/**
	 * Previous calls within the interval.
	 */
	private final long[] _ticks;

	/**
	 * Available element at the insertion point (back of the queue).
	 */
	private int _tickNext;

	/**
	 * Element at the removal point (front of the queue).
	 */
	private int _tickLast;

	/**
	 * the time when the last expired request occured. might be used to auto
	 * disable some services all together
	 */
	private long _lastExpiredMaxWait = 0;

	/**
	 * Constructor.
	 * 
	 * @param maxCalls
	 *            Max number of calls that can be made within the interval.
	 * @param interval
	 *            The interval.
	 */
	public RequestThrottler(final int maxCalls, final long interval) {
		if (maxCalls < 1) {
			throw new IllegalArgumentException("maxCalls must be >=1, was " + maxCalls);
		}
		if (interval < 1) {
			throw new IllegalArgumentException("interval must be >=1, was " + interval);
		}
		_interval = interval;
		_maxCalls = maxCalls + 1;
		_ticks = new long[_maxCalls];
		_tickLast = _tickNext = 0;
	}

	/**
	 * Returns the next element in the queue.
	 * 
	 * @param index
	 *            The element for which to compute the next.
	 * @return
	 */
	private int next(int index) {
		index += 1;
		return index < _maxCalls ? index : 0;
	}

	/**
	 * Attempts to clear the request.
	 * 
	 * @return Returns 0 if successful, or a time hint (ms) in which we should
	 *         attempt to clear it again.
	 */
	public synchronized long tryStartRequest() {
		long result = 0;
		final long now = System.currentTimeMillis();
		while (_tickLast != _tickNext) {
			if (now - _ticks[_tickLast] < _interval) {
				break;
			}
			_tickLast = next(_tickLast);
		}

		final int next = next(_tickNext);
		if (next != _tickLast) {
			_ticks[_tickNext] = now;
			_tickNext = next;
		} else {
			result = _interval - (now - _ticks[_tickLast]);
		}
		return result;
	}

	/**
	 * Clears the request. Blocks until the request can execute.
	 */
	public void startRequest() {
		startRequest(Integer.MAX_VALUE);
	}

	/**
	 * Clears the request. Blocks until the request can execute or until waxWait
	 * would be exceeded.
	 * 
	 * @return true if successful or false if request should not execute
	 */
	public boolean startRequest(final int maxWait) {
		long sleep;
		long total = 0;
		while ((sleep = tryStartRequest()) > 0) {
			if (maxWait > 0 && (total += sleep) > maxWait) {
				_lastExpiredMaxWait = System.currentTimeMillis();
				return false;
			} else {
				try {
					Thread.sleep(sleep);
				} catch (final InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
		return true;
	}

	/*
	 * public long getLastExpiredMaxWait() { return _lastExpiredMaxWait; }
	 * 
	 * private static final int MAX_CALLS = 10; private static final int
	 * PER_INTERVAL = 60000; // 60s private static final int MAX_WAIT = 2000; //
	 * 2s
	 * 
	 * private RequestThrottler _throttler = new RequestThrottler(MAX_CALLS,
	 * PER_INTERVAL); private SomeWebService _service = new SomeWebService();
	 * 
	 * public void callService() { throttler.startRequest(MAX_WAIT);
	 * _service.call(); }
	 */
}