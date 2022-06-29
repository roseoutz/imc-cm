package io.ims.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * packageName    : io.ims.common.util
 * fileName       : DateUtil
 * author         : kimdonggyuuuuu
 * date           : 2022/06/28
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/06/28        kimdonggyuuuuu       최초 생성
 */
public class DateUtil {

    private DateUtil(){}

    public static final String SDF_YMD = "yyyy-MM-dd";
    public static final String SDF = "yyyy-MM-dd HH:mm:ss";
    public static final String SDF_TZ = "yyyy-MM-dd'T'HH:mm:ssZ";


    /**
     * 1/1000 초를 초 단위로 @TODO
     * @param time
     * @return
     */
    public static long miliToSecond(long time) {
        if( time > 1000000000000L ) {
            return time/1000;
        }

        return time;
    }

    /**
     *  초를  1/1000초 단위로 @TODO
     * @param time
     * @return
     */
    public static long secondToMili(long time) {
        if( time < 10000000000L ) {
            return time*1000;
        }
        return time;
    }

    public static Timestamp getNow() {
        Timestamp tsNow = new Timestamp(currentTime());
        tsNow.setNanos(0);

        return tsNow;
    }

    public static Timestamp getFuture( int minutes){
        long future = currentTime() + (Long.valueOf( minutes) * Long.valueOf(60) * Long.valueOf(1000));
        return new Timestamp( future);
    }

    /**
     * 현재시간 초단위
     * @return
     */
    public static long currentSecond() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 현재시간
     * @return
     */
    public static long currentTime() {
        return System.currentTimeMillis();
    }

    /**
     * value 만큼 더하거나 뺀 시간
     * @param value
     * @return
     */
    public static long currentTime(long value) {
        return currentTime() + value;
    }

    /**
     * 현재 시간 문자열
     * @return
     */
    public static String currentTimeString() {
        return currentTime() + "";
    }

    /**
     * 현재시간 (yyyyMMdd)
     * @return
     */
    public static String getCurrentYMD() {
        return new SimpleDateFormat(SDF_YMD).format(new Date(currentTime()));
    }

    /**
     * 현재시간 (yyyyMMdd)
     * @param time
     * @return
     */
    public static String getYMDString(long time) {
        return new SimpleDateFormat(SDF_YMD).format(new Date(time));
    }

    /**
     * 현재시간 + 추가(분) (yyyy-MM-dd)
     * @param addDay
     * @return
     */
    public static String getYMDFromToday(Integer addDay) {
        long currentTimeMillis = currentTime();
        long resultTimeMillis = currentTimeMillis + (Long.valueOf(addDay) * Long.valueOf(24) * Long.valueOf(60) * Long.valueOf(60) * Long.valueOf(1000));

        return new SimpleDateFormat(SDF_YMD).format(new Date(resultTimeMillis));
    }

    /**
     * 현재시간 (yyyy-MM-dd HH:mm:ss)
     * @return
     */
    public static String getCurrentDate() {
        return new SimpleDateFormat(SDF).format(new Date(currentTime()));
    }

    public static String getDateString(long time) {
        return new SimpleDateFormat(SDF).format(new Date(time));
    }

    public static String getCurrentDateFormat( String format) {
        return new SimpleDateFormat( format).format(new Date(currentTime()));
    }

    /**
     * 현재시간 + 추가(분) (yyyy-MM-dd HH:mm:ss)
     * @param addMinute
     * @return
     */
    public static String getDateFromCurrent(Integer addMinute) {
        long currentTimeMillis = currentTime();
        long resultTimeMillis = currentTimeMillis + (Long.valueOf(addMinute) * Long.valueOf(60) * Long.valueOf(1000));

        return new SimpleDateFormat(SDF).format(new Date(resultTimeMillis));
    }

    public static long getTimeFromCurrent(Integer addMinute) {
        long currentTimeMillis = currentTime();
        return currentTimeMillis + (Long.valueOf(addMinute) * Long.valueOf(60) * Long.valueOf(1000));
    }

    /**
     * TimeMillis 형태로 변환
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static long getTimeMillis(String dateStr) throws ParseException {
        Date changeDate = new SimpleDateFormat(SDF).parse(dateStr);
        return changeDate.getTime();
    }

    /**
     * 조회된 시간 + 추가(분) TimeMillis 형태로 변환
     * @param timeMillis
     * @param addMinute
     * @return
     */
    public static long getAddTimeMillis(long timeMillis, Integer addMinute) {
        return timeMillis + (Long.valueOf(addMinute) * Long.valueOf(60) * Long.valueOf(1000));
    }

    public static String[] getYMDH( long time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis( time);

        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        String date = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));

        return new String[]{ year, month, date, hour};
    }



    public static String getDateTimeString( Timestamp time) {
        return new SimpleDateFormat(SDF_TZ).format(new Date(time.getTime()));
    }

    public static String getDateTimeString( long time) {
        return new SimpleDateFormat(SDF_TZ).format(new Date(time));
    }


    public static boolean dateCheck(String date, String format) {
        SimpleDateFormat dateFormatParser = new SimpleDateFormat(format);
        dateFormatParser.setLenient(false);

        try {
            dateFormatParser.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }

    }
}
