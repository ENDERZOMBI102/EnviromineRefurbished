package com.enderzombi102.emr.api;

/**
 * Interface for items that want to specify their own rottening times.
 */
public interface RotProvider {
	int getRotDays();
}
