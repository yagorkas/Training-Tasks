package trainingTask2.p3;

public class ExtendedClass {
    byte b;
    int i;
    double d;
    String s;

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject == null || getClass() != anObject.getClass()) return false;
        ExtendedClass that = (ExtendedClass) anObject;
        return this.b == that.b &&
                this.i == that.i &&
                this.d == that.d &&
                s.equals(that.s);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = result*prime + b;
        result = result*prime + i;
        result = result*prime + (d == 0 ? 0 : ((Double)d).hashCode());
        result = result*prime + (s == null ? 0 : s.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ExtendedClass{" +
                "b=" + b +
                ", i=" + i +
                ", d=" + d +
                ", s='" + s + '\'' +
                '}';
    }
}
