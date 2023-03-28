package com.song.enums;

/**
 * @author: Laity
 * @Project: JavaLaity
 * @Package: com.intelligent.car.enums.CarDataEnum
 * @Date: 2022年08月04日 10:07
 * @Description: 车数据同步枚举
 */

public enum CarDataEnum {
    ONE(1, "终端-链路日志"),
    TWO(2, "终端-系统日志"),
    THREE(3, "终端-登录日志"),
    FOUR(4, "终端-指控日志"),
    FIVE(5, "车辆数据"),
    SIX(6, "中心-系统日志"),
    SEVEN(7, "中心-登录日志"),
    EIGHT(8, "中心-指控日志");

    public Integer type;
    public String value;

    CarDataEnum(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
