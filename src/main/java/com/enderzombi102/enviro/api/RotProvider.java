package com.enderzombi102.enviro.api;

/**
 * Interface for items that want to specify their own rottening times.
 */
public interface RotProvider {
	int getRotDays();
}
