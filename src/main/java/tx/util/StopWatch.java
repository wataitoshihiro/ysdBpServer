/*
 * Copyright 2015 FUJITSU LIMITED
 *
 * INTERNAL USE ONLY
 */
package tx.util;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 時間計測クラス
 */
public class StopWatch
{
	//Logger
	private static Logger logger = LoggerFactory.getLogger(StopWatch.class);
	
	private long startTime = 0;
	private long endTime = 0;
	private long excuteTime = 0;
	
	/**
	 * コンストラクタ
	 *
	 * @param debug
	 */
	public StopWatch()
	{
	}
	
	/**
	 * 計測をスタートする。
	 */
	public void start() {
		logger.debug("start !");
		startTime = System.currentTimeMillis();
	}
	
	/**
	 * 計測を終了する。
	 *
	 * @return 経過時間
	 */
	private long stop()
	{
		logger.debug("stop !");
		endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
	
	/**
	 * 計測時間をレポートする。
	 *
	 * @param comment
	 * @return 計測時間
	 */
	public long stopReport(String comment)
	{
		setExcuteTime(stop());
		report(comment, excuteTime);
		return excuteTime;
		
		//		long msec = stop();
		//		report(comment, msec);
		//		return msec;
	}
	
	/**
	 * 計測時間をレポートする。
	 *
	 * @param comment
	 * @param response
	 */
	private void report(String comment, long msec)
	{
		long duration = endTime - startTime;
		String format = null;
		if (duration >= (60 * 60 * 1000))
			format = "H時間:m分:s秒.Sミリ秒";
		else if (duration >= (1 * 60 * 1000))
			format = "m分:s秒.Sミリ秒";
		else if (duration >= (1000))
			format = "s秒.Sミリ秒";
		else
			format = "Sミリ秒";
		String diffTime =
				DurationFormatUtils.formatPeriod(startTime, endTime, format);
		logger.info(comment + "[{}]", diffTime);
		
		//		long sec = msec / 1000;
		//		long min = sec / 60;
		//		logger.info(comment + "\t{}msec\t{}sec\t{}min", msec, sec, min);
		//		logger.info(comment + "\t" +
		//				"{}" + "msec" + "\t" +
		//				"{}" + "sec" + "\t" +
		//				"{}" + "min", msec, sec, min);
		//		if (debug)
		//		{
		//			System.out.println(comment + "\t" +
		//					msec + "msec" + "\t" +
		//					sec + "sec" + "\t" +
		//					min + "min");
		//		}
	}
	
	public long getExcuteTime()
	{
		return excuteTime;
	}
	
	private void setExcuteTime(long excuteTime)
	{
		this.excuteTime = excuteTime;
	}
}
