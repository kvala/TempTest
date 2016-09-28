package test;

import java.util.concurrent.TimeUnit;

/*
rate = 5.0; // unit: messages
per  = 8.0; // unit: seconds
allowance = rate; // unit: messages
last_check = now(); // floating-point, e.g. usec accuracy. Unit: seconds

when (message_received):
  current = now();
  time_passed = current - last_check;
  last_check = current;
  allowance += time_passed * (rate / per);
  if (allowance > rate):
    allowance = rate; // throttle
  if (allowance < 1.0):
    discard_message();
  else:
    forward_message();
    allowance -= 1.0;
  */
public class RateLimit {
	int rate;
	long per;
	String unit;
	TimeUnit limit;
	private long lastCheck;
	private long lastFilled;
	private int allowance;

	public RateLimit() {
	}

	public RateLimit(int rate, TimeUnit limit, long per) {
		this.rate = rate;
		this.limit = limit;
		this.per = per;
		lastFilled = lastCheck = System.currentTimeMillis();
		allowance = rate;
	}

	public int getRate() {
		return rate;
	}

	public TimeUnit getLimit() {
		return limit;
	}

	public long getLastCheck() {
		return lastCheck;
	}

	public int getAllowance() {
		return allowance;
	}

	public boolean record(int messages) {
		long now = System.currentTimeMillis();
		long elapsed = now - lastFilled;

		if (elapsed > limit.toMillis(per)) {
			allowance = rate;
			lastFilled = now;
		}
		allowance -= messages;
		lastCheck = now;
		return allowance >= 0;
	}

	@Override
	public String toString() {
		return "RateLimit{" + "rate=" + rate + ", limit=" + limit + '}';
	}

	public static void main(String[] args) throws Exception {
		RateLimit rateLimit = new RateLimit(10, TimeUnit.SECONDS, 1);
		System.out.println("RateLimit.main " + rateLimit);
		for (int i = 0; i < 110; i++) {
			System.out.println(i + " " + rateLimit.record(1));

		}
		Thread.sleep(5000L);
		System.out.println("After sleep");
		for (int i = 0; i < 110; i++) {
			System.out.println(i + " " + rateLimit.record(1));
		}
	}
}