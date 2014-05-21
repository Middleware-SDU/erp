package cn.edu.sdu.erp.core.db.hibernate;

import org.hibernate.dialect.H2Dialect;

/**
 * A workaround for https://hibernate.atlassian.net/browse/HHH-7002
 * 
 * @author Christian Bauer
 * @see https://hibernate.atlassian.net/browse/HHH-7002?focusedCommentId=45268&page=com.atlassian.jira.plugin.system.issuetabpanels:comment-tabpanel#comment-45268
 */
public class ImprovedH2Dialect extends H2Dialect {

    @Override
    public String getDropSequenceString(String sequenceName) {
        // Adding the "if exists" clause to avoid warnings
        return "drop sequence if exists " + sequenceName;
    }

    @Override
    public boolean dropConstraints() {
        // We don't need to drop constraints before dropping tables, that just leads to error
        // messages about missing tables when we don't have a schema in the database
        return false;
    }

}
