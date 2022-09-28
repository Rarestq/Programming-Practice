package com.rarestzhou.bookonjava.advance.references;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/19 1:24 PM
 * @description: 克隆组合对象
 */
public class OceanReading implements Cloneable {

    private DepthReading depthReading;
    private TemperatureReading temperatureReading;

    public OceanReading(double tdata, double ddata) {
        temperatureReading = new TemperatureReading(tdata);
        depthReading = new DepthReading(ddata);
    }

    @Override
    public OceanReading clone() {
        OceanReading or = null;
        try {
            or = (OceanReading) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        // 必须克隆引用
        or.depthReading = (DepthReading) or.depthReading.clone();
        or.temperatureReading = (TemperatureReading) or.temperatureReading.clone();
        return or;
    }

    public DepthReading getDepthReading() {
        return depthReading;
    }

    public void setDepthReading(DepthReading depthReading) {
        this.depthReading = depthReading;
    }

    public TemperatureReading getTemperatureReading() {
        return temperatureReading;
    }

    public void setTemperatureReading(TemperatureReading temperatureReading) {
        this.temperatureReading = temperatureReading;
    }

    @Override
    public String toString() {
        return "temperatureReading: " + temperatureReading + ", depthReading: " + depthReading;
    }
}
