package uk.co.bcl.genie.model;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SalesCloudOpportunityListVO implements Serializable {

    static Logger logger = LogManager.getRootLogger();

    @SuppressWarnings("compatibility:977088170496345326")
    private static final long serialVersionUID = 1L;

    private List<SalesCloudOpportunityVO> items = new ArrayList<SalesCloudOpportunityVO>();

    private Integer count;
    private boolean hasMore;
    private Integer limit;
    private Integer offset;
    private Integer totalResults;

    public void setTotalResults(Integer totalResults) {
        logger.entry();
        this.totalResults = totalResults;
        logger.exit();
    }

    public Integer getTotalResults() {
        logger.entry();
        logger.exit();
        return totalResults;
    }

    public List<SalesCloudOpportunityVO> getItems() {
        logger.entry();
        logger.exit();
        return items;
    }

    public void setItems(List<SalesCloudOpportunityVO> items) {
        logger.entry();
        this.items = items;
        logger.exit();
    }

    public void setCount(Integer count) {
        logger.entry();
        this.count = count;
        logger.exit();
    }

    public Integer getCount() {
        logger.entry();
        logger.exit();
        return count;
    }

    public void setHasMore(boolean hasMore) {
        logger.entry();
        this.hasMore = hasMore;
        logger.exit();
    }

    public boolean isHasMore() {
        logger.entry();
        logger.exit();
        return hasMore;
    }

    public void setLimit(Integer limit) {
        logger.entry();
        this.limit = limit;
        logger.exit();
    }

    public Integer getLimit() {
        logger.entry();
        logger.exit();
        return limit;
    }

    public void setOffset(Integer offset) {
        logger.entry();
        this.offset = offset;
        logger.exit();
    }

    public Integer getOffset() {
        logger.entry();
        logger.exit();
        return offset;
    }


    @Override
    public String toString() {

        logger.entry();

        Field[] fields = this.getClass().getDeclaredFields();

        StringBuilder outputItems = new StringBuilder();
        StringBuilder output = new StringBuilder();

        for (SalesCloudOpportunityVO item : this.items) {
            if (outputItems.length() != 0) {
                outputItems.append(", ");
            }

            outputItems.append(item.toString());
        }

        output.append("\"items\" : [" + outputItems + "]");

        for (Field f : fields) {
            logger.debug("Field: " + f.toString());

            Class t = f.getType();
            if (!(t == Logger.class) && !(f.getName() == "serialVersionUID")) {

                if (output.length() != 0) {
                    output.append(", ");
                }

                Object v;
                try {
                    v = f.get(this);
                } catch (IllegalAccessException e) {
                    v = "null";
                }

                output.append("\"" + f.getName() + "\" : ");

                if (t == boolean.class)
                    output.append(Boolean.TRUE.equals(v));
                else if (t == String.class)
                    output.append("\"" + v + "\"");
                else
                    output.append("ERROR"); //v.toString());
            }
        }

        logger.exit();

        return "{" + output + "}";
    }


    public String getDataAsString() {
        logger.entry();

        String newline = System.getProperty("line.separator");

        StringBuffer output = new StringBuffer();

        for (SalesCloudOpportunityVO item : items) {
            if (output.length() != 0) {
                output.append(newline);
            }
            output.append(item.getDataAsString());
        }

        logger.debug(output);

        logger.exit();

        return output.toString();
    }
}
