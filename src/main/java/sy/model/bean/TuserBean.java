package sy.model.bean;
/*
 * Copyright(c) 2016 expo.ofweek.com All rights reserved.
 * distributed with this file and available online at
 * http://expo.ofweek.com/
 */
import com.dap.dao.model.Order;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TuserBean {
    /**
     * order by 排序语句
     * 对应数据库表字段 tuser
     */
    private List<Order> orderBy;

    /**
     * 分页开始记录
     * 对应数据库表字段 tuser
     */
    private Integer pageIndex;

    /**
     * 分页大小
     * 对应数据库表字段 tuser
     */
    private int pageSize = 10;

    /**
     * 是否指定 distinct 去除重复
     * 对应数据库表字段 tuser
     */
    private boolean distinct;

    /**
     * 逻辑or语句
     * 对应数据库表字段 tuser
     */
    private List<Criteria> oredCriteria;

    /**
     */
    public TuserBean() {
        oredCriteria = new ArrayList<Criteria>();
    }
	
	
	public void setPageIndexAndSize(Integer pageIndex, Integer pageSize) {
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}

    /**
     * 设置 order by 排序语句
     */
    public void setOrderBy(List<Order> orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * 获得 order by 排序语句
     */
    public List<Order> getOrderBy() {
        return orderBy;
    }
	
	public void addOrderBy(Order order) {
		if (null == this.orderBy)
			this.orderBy = new ArrayList<>();
		this.orderBy.add(order);
	}

    /**
     * 设置 pageIndex，分页开始记录
     */
    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * 获得 pageIndex，分页开始记录
     */
    public Integer getPageIndex() {
        return pageIndex;
    }

    /**
     * 设置 pageSize，分页大小
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获得 pageSize，分页大小
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置是否指定 distinct 去除重复
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 是否设置了distinct语句，true是，false否。
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 获得逻辑or语句
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 添加逻辑or语句
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 添加逻辑and语句
     */
    public void and(Criteria criteria) {
        criteria.setAndRelation(true);
        oredCriteria.add(criteria);
    }

    /**
     * 新建逻辑或or语句
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 新建逻辑and语句
     */
    public Criteria and() {
        Criteria criteria = createCriteriaInternal();
        criteria.setAndRelation(true);
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 创建查询条件，如果逻辑或为空，同时将查询条件放入。
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 创建新查询条件。
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 清除逻辑或or语句，并且distinct为false，不去重。
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * 该类对应数据库表 tuser
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void orCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition, true));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void orCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value, true));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void orCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2, true));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Timestamp(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Timestamp> dateList = new ArrayList<java.sql.Timestamp>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Timestamp(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Timestamp(value1.getTime()), new java.sql.Timestamp(value2.getTime()), property);
        }
        
        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }
        
        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }
        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }
        
        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }
        public Criteria orIdIsNull() {
            orCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria orIdIsNotNull() {
            orCriterion("ID is not null");
            return (Criteria) this;
        }
        public Criteria orIdEqualTo(String value) {
            orCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria orIdNotEqualTo(String value) {
            orCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria orIdGreaterThan(String value) {
            orCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria orIdGreaterThanOrEqualTo(String value) {
            orCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria orIdLessThan(String value) {
            orCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria orIdLessThanOrEqualTo(String value) {
            orCriterion("ID <=", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria orIdLike(String value) {
            orCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria orIdNotLike(String value) {
            orCriterion("ID not like", value, "id");
            return (Criteria) this;
        }
        
        
        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria orIdIn(List<String> values) {
            orCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria orIdNotIn(List<String> values) {
            orCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria orIdBetween(String value1, String value2) {
            orCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria orIdNotBetween(String value1, String value2) {
            orCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }
        public Criteria andCreatedatetimeIsNull() {
            addCriterion("CREATEDATETIME is null");
            return (Criteria) this;
        }
        
        public Criteria andCreatedatetimeIsNotNull() {
            addCriterion("CREATEDATETIME is not null");
            return (Criteria) this;
        }
        public Criteria andCreatedatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("CREATEDATETIME =", value, "createdatetime");
            return (Criteria) this;
        }
        
        public Criteria andCreatedatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATEDATETIME <>", value, "createdatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATEDATETIME >", value, "createdatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATEDATETIME >=", value, "createdatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedatetimeLessThan(Date value) {
            addCriterionForJDBCDate("CREATEDATETIME <", value, "createdatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATEDATETIME <=", value, "createdatetime");
            return (Criteria) this;
        }
        public Criteria orCreatedatetimeIsNull() {
            orCriterion("CREATEDATETIME is null");
            return (Criteria) this;
        }

        public Criteria orCreatedatetimeIsNotNull() {
            orCriterion("CREATEDATETIME is not null");
            return (Criteria) this;
        }
        
        
        public Criteria andCreatedatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("CREATEDATETIME in", values, "createdatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATEDATETIME not in", values, "createdatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATEDATETIME between", value1, value2, "createdatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATEDATETIME not between", value1, value2, "createdatetime");
            return (Criteria) this;
        }
        public Criteria andModifydatetimeIsNull() {
            addCriterion("MODIFYDATETIME is null");
            return (Criteria) this;
        }
        
        public Criteria andModifydatetimeIsNotNull() {
            addCriterion("MODIFYDATETIME is not null");
            return (Criteria) this;
        }
        public Criteria andModifydatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("MODIFYDATETIME =", value, "modifydatetime");
            return (Criteria) this;
        }
        
        public Criteria andModifydatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("MODIFYDATETIME <>", value, "modifydatetime");
            return (Criteria) this;
        }

        public Criteria andModifydatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("MODIFYDATETIME >", value, "modifydatetime");
            return (Criteria) this;
        }

        public Criteria andModifydatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("MODIFYDATETIME >=", value, "modifydatetime");
            return (Criteria) this;
        }

        public Criteria andModifydatetimeLessThan(Date value) {
            addCriterionForJDBCDate("MODIFYDATETIME <", value, "modifydatetime");
            return (Criteria) this;
        }

        public Criteria andModifydatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("MODIFYDATETIME <=", value, "modifydatetime");
            return (Criteria) this;
        }
        public Criteria orModifydatetimeIsNull() {
            orCriterion("MODIFYDATETIME is null");
            return (Criteria) this;
        }

        public Criteria orModifydatetimeIsNotNull() {
            orCriterion("MODIFYDATETIME is not null");
            return (Criteria) this;
        }
        
        
        public Criteria andModifydatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("MODIFYDATETIME in", values, "modifydatetime");
            return (Criteria) this;
        }

        public Criteria andModifydatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("MODIFYDATETIME not in", values, "modifydatetime");
            return (Criteria) this;
        }

        public Criteria andModifydatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("MODIFYDATETIME between", value1, value2, "modifydatetime");
            return (Criteria) this;
        }

        public Criteria andModifydatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("MODIFYDATETIME not between", value1, value2, "modifydatetime");
            return (Criteria) this;
        }
        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }
        
        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }
        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }
        
        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }
        public Criteria orNameIsNull() {
            orCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria orNameIsNotNull() {
            orCriterion("NAME is not null");
            return (Criteria) this;
        }
        public Criteria orNameEqualTo(String value) {
            orCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria orNameNotEqualTo(String value) {
            orCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria orNameGreaterThan(String value) {
            orCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria orNameGreaterThanOrEqualTo(String value) {
            orCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria orNameLessThan(String value) {
            orCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria orNameLessThanOrEqualTo(String value) {
            orCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }
        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria orNameLike(String value) {
            orCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria orNameNotLike(String value) {
            orCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }
        
        
        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria orNameIn(List<String> values) {
            orCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria orNameNotIn(List<String> values) {
            orCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria orNameBetween(String value1, String value2) {
            orCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria orNameNotBetween(String value1, String value2) {
            orCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }
        public Criteria andPwdIsNull() {
            addCriterion("PWD is null");
            return (Criteria) this;
        }
        
        public Criteria andPwdIsNotNull() {
            addCriterion("PWD is not null");
            return (Criteria) this;
        }
        public Criteria andPwdEqualTo(String value) {
            addCriterion("PWD =", value, "pwd");
            return (Criteria) this;
        }
        
        public Criteria andPwdNotEqualTo(String value) {
            addCriterion("PWD <>", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThan(String value) {
            addCriterion("PWD >", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThanOrEqualTo(String value) {
            addCriterion("PWD >=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThan(String value) {
            addCriterion("PWD <", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThanOrEqualTo(String value) {
            addCriterion("PWD <=", value, "pwd");
            return (Criteria) this;
        }
        public Criteria orPwdIsNull() {
            orCriterion("PWD is null");
            return (Criteria) this;
        }

        public Criteria orPwdIsNotNull() {
            orCriterion("PWD is not null");
            return (Criteria) this;
        }
        public Criteria orPwdEqualTo(String value) {
            orCriterion("PWD =", value, "pwd");
            return (Criteria) this;
        }

        public Criteria orPwdNotEqualTo(String value) {
            orCriterion("PWD <>", value, "pwd");
            return (Criteria) this;
        }

        public Criteria orPwdGreaterThan(String value) {
            orCriterion("PWD >", value, "pwd");
            return (Criteria) this;
        }

        public Criteria orPwdGreaterThanOrEqualTo(String value) {
            orCriterion("PWD >=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria orPwdLessThan(String value) {
            orCriterion("PWD <", value, "pwd");
            return (Criteria) this;
        }

        public Criteria orPwdLessThanOrEqualTo(String value) {
            orCriterion("PWD <=", value, "pwd");
            return (Criteria) this;
        }
        public Criteria andPwdLike(String value) {
            addCriterion("PWD like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotLike(String value) {
            addCriterion("PWD not like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria orPwdLike(String value) {
            orCriterion("PWD like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria orPwdNotLike(String value) {
            orCriterion("PWD not like", value, "pwd");
            return (Criteria) this;
        }
        
        
        public Criteria andPwdIn(List<String> values) {
            addCriterion("PWD in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotIn(List<String> values) {
            addCriterion("PWD not in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdBetween(String value1, String value2) {
            addCriterion("PWD between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotBetween(String value1, String value2) {
            addCriterion("PWD not between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria orPwdIn(List<String> values) {
            orCriterion("PWD in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria orPwdNotIn(List<String> values) {
            orCriterion("PWD not in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria orPwdBetween(String value1, String value2) {
            orCriterion("PWD between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria orPwdNotBetween(String value1, String value2) {
            orCriterion("PWD not between", value1, value2, "pwd");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应数据库表 tuser
     */
    public static class Criteria extends GeneratedCriteria {
        protected boolean andRelation;

        public boolean isAndRelation() {
            return andRelation;
        }

        protected Criteria() {
            super();
        }

        public void setAndRelation(boolean andRelation) {
            this.andRelation = andRelation;
        }
    }

    /**
     * 该类对应数据库表 tuser
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean orValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isOrValue() {
            return orValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, boolean orValue) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
            this.orValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, boolean orValue) {
            this(condition, value, null);
            this.orValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, boolean orValue) {
            this(condition, value, secondValue, null);
            this.orValue = true;
        }
    }
}