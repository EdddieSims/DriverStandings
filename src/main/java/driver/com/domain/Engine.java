package driver.com.domain;

import driver.com.interfaces.IEngine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Edmund.Simons on 2016/03/29.
 */
@Entity
public class Engine implements IEngine, Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;
    private int numOfPistons;
    private double powerOutput;

    public Engine() {
    }

    public Engine(Builder builder)
    {
        this.id = builder.id;
        this.brand = builder.brand;
        this.model = builder.model;
        this.numOfPistons = builder.numOfPistons;
        this.powerOutput = builder.powerOutput;
    }

    public static class Builder
    {
        Long id;
        String brand;
        String model;
        int numOfPistons;
        double powerOutput;

        public Builder(String value)
        {
            this.brand = value;
        }

        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder brand(String value)
        {
            this.brand = value;
            return this;
        }

        public Builder model(String value)
        {
            this.model = value;
            return this;
        }

        public Builder numOfPistons(int value)
        {
            this.numOfPistons = value;
            return this;
        }

        public Builder powerOutput(double value)
        {
            this.powerOutput = value;
            return this;
        }

        public Builder copy(Engine value)
        {
            this.id = value.id;
            this.brand = value.brand;
            this.model = value.model;
            this.numOfPistons = value.numOfPistons;
            this.powerOutput = value.powerOutput;
            return this;
        }

        public Engine build()
        {
            return new Engine(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Engine engine = (Engine) o;

        if (numOfPistons != engine.numOfPistons) return false;
        if (Double.compare(engine.powerOutput, powerOutput) != 0) return false;
        if (!id.equals(engine.id)) return false;
        if (brand != null ? !brand.equals(engine.brand) : engine.brand != null) return false;
        return model != null ? model.equals(engine.model) : engine.model == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id.hashCode();
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + numOfPistons;
        temp = Double.doubleToLongBits(powerOutput);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String getBrand() {
        return brand;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getNumOfPistons() {
        return numOfPistons;
    }

    public double getPowerOutput() {
        return powerOutput;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", numOfPistons=" + numOfPistons +
                ", powerOutput=" + powerOutput +
                '}';
    }
}
