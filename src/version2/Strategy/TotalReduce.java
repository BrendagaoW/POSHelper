package version2.Strategy;

import version2.Records.Item;

import java.util.List;

/**
 * Created by Brenda on 12/15/14.
 */
public class TotalReduce{
    private float total;
    private float reduce;

    public TotalReduce(float total, float reduce) {
        this.total = total;
        this.reduce = reduce;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getReduce() {
        return reduce;
    }

    public void setReduce(float reduce) {
        this.reduce = reduce;
    }
}
