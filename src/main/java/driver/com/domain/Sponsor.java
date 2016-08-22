package driver.com.domain;

import driver.com.interfaces.ISponsor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Edmund.Simons on 2016/03/29.
 */
@Entity
public class Sponsor implements ISponsor, Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String logoColour;

    public Sponsor() {
    }

    public Sponsor(Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
        this.logoColour = builder.logoColour;
    }

    public static class Builder
    {
        Long id;
        String name;
        String logoColour;

        public Builder(String value)
        {
            this.name = value;
        }

        public Builder name(String value)
        {
            this.name = value;
            return this;
        }

        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder logoColour(String value)
        {
            this.logoColour = value;
            return this;
        }

        public Builder copy(Sponsor value)
        {
            this.id = value.id;
            this.name = value.name;
            this.logoColour = value.logoColour;
            return this;
        }

        public Sponsor build()
        {
            return new Sponsor(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogoColour() {
        return logoColour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sponsor sponsor = (Sponsor) o;

        if (!id.equals(sponsor.id)) return false;
        return name != null ? name.equals(sponsor.name) : sponsor.name == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Sponsor{" +
                "name='" + name + '\'' +
                '}';
    }
}
