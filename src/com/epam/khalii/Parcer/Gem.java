package com.epam.khalii.Parcer;

/**
 * Created by Anhelina_Khalii on 07.05.2015.
 */
public class Gem {
    private String name;
    private String precious;
    private String origin;
    private double value;
    public VisualComponents visualComponents;

    class VisualComponents{
        private String color;
        private int opacity;
        private int cut;

        public VisualComponents() {
            color = "";
            opacity = 0;
            cut = 0;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getOpacity() {
            return opacity;
        }

        public void setOpacity(int opacity) {
            if (opacity>=0&&opacity<=100)
                this.opacity = opacity;
            else throw new IllegalArgumentException();
        }

        public int getCut() {
            return cut;
        }

        public void setCut(int cut) {
            if(cut>=4&&cut<=15)
                this.cut = cut;
            else throw new IllegalArgumentException();
        }

        public VisualComponents(String color, int opacity, int cut) {
            this.setColor(color);
            this.setOpacity(opacity);
            this.setCut(cut);
        }

        @Override
        public String toString() {
            return "{" +
                    "color='" + color + '\'' +
                    ", opacity=" + opacity +
                    ", cut=" + cut +
                    "}";
        }
    }

    public Gem(String name, String precious, String origin, String color, int opacity, int cut, double value) {
        this.setName(name);
        this.setPrecious(precious);
        this.setOrigin(origin);
        this.setValue(value);
        visualComponents = new VisualComponents(color, opacity, cut);
    }

    public Gem() {
        VisualComponents visualComponents = new VisualComponents();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrecious() {
        return precious;
    }

    public void setPrecious(String precious) {
        this.precious = precious;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Gem{" +
                "name='" + name + '\'' +
                ", precious='" + precious + '\'' +
                ", origin='" + origin + '\'' +
                ", value=" + value +
                ", visualComponents=" + visualComponents +
                '}';
    }
}
