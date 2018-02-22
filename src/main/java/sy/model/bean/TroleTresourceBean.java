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

public class TroleTresourceBean {
    /**
     * order by 排序语句
     * 对应数据库表字段 trole_tresource
     */
    private List<Order> orderBy;

    /**
     * 分页开始记录
     * 对应数据库表字段 trole_tresource
     */
    private Integer pageIndex;

    /**
     * 分页大小
     * 对应数据库表字段 trole_tresource
     */
    private int pageSize = 10;

    /**
     * 是否指定 distinct 去除重复
     * 对应数据库表字段 trole_tresource
     */
    private boolean distinct;

    /**
     * 逻辑or语句
     * 对应数据库表字段 trole_tresource
     */
    private List<Criteria> oredCriteria;

    /**
     */
    public TroleTresourceBean() {
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
     * 该类对应数据库表 trole_tresource
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
        
        public Criteria andTroleIdIsNull() {
            addCriterion("TROLE_ID is null");
            return (Criteria) this;
        }
        
        public Criteria andTroleIdIsNotNull() {
            addCriterion("TROLE_ID is not null");
            return (Criteria) this;
        }
        public Criteria andTroleIdEqualTo(String value) {
            addCriterion("TROLE_ID =", value, "troleId");
            return (Criteria) this;
        }
        
        public Criteria andTroleIdNotEqualTo(String value) {
            addCriterion("TROLE_ID <>", value, "troleId");
            return (Criteria) this;
        }

        public Criteria andTroleIdGreaterThan(String value) {
            addCriterion("TROLE_ID >", value, "troleId");
            return (Criteria) this;
        }

        public Criteria andTroleIdGreaterThanOrEqualTo(String value) {
            addCriterion("TROLE_ID >=", value, "troleId");
            return (Criteria) this;
        }

        public Criteria andTroleIdLessThan(String value) {
            addCriterion("TROLE_ID <", value, "troleId");
            return (Criteria) this;
        }

        public Criteria andTroleIdLessThanOrEqualTo(String value) {
            addCriterion("TROLE_ID <=", value, "troleId");
            return (Criteria) this;
        }
        public Criteria orTroleIdIsNull() {
            orCriterion("TROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria orTroleIdIsNotNull() {
            orCriterion("TROLE_ID is not null");
            return (Criteria) this;
        }
        public Criteria orTroleIdEqualTo(String value) {
            orCriterion("TROLE_ID =", value, "troleId");
            return (Criteria) this;
        }

        public Criteria orTroleIdNotEqualTo(String value) {
            orCriterion("TROLE_ID <>", value, "troleId");
            return (Criteria) this;
        }

        public Criteria orTroleIdGreaterThan(String value) {
            orCriterion("TROLE_ID >", value, "troleId");
            return (Criteria) this;
        }

        public Criteria orTroleIdGreaterThanOrEqualTo(String value) {
            orCriterion("TROLE_ID >=", value, "troleId");
            return (Criteria) this;
        }

        public Criteria orTroleIdLessThan(String value) {
            orCriterion("TROLE_ID <", value, "troleId");
            return (Criteria) this;
        }

        public Criteria orTroleIdLessThanOrEqualTo(String value) {
            orCriterion("TROLE_ID <=", value, "troleId");
            return (Criteria) this;
        }
        public Criteria andTroleIdLike(String value) {
            addCriterion("TROLE_ID like", value, "troleId");
            return (Criteria) this;
        }

        public Criteria andTroleIdNotLike(String value) {
            addCriterion("TROLE_ID not like", value, "troleId");
            return (Criteria) this;
        }

        public Criteria orTroleIdLike(String value) {
            orCriterion("TROLE_ID like", value, "troleId");
            return (Criteria) this;
        }

        public Criteria orTroleIdNotLike(String value) {
            orCriterion("TROLE_ID not like", value, "troleId");
            return (Criteria) this;
        }
        
        
        public Criteria andTroleIdIn(List<String> values) {
            addCriterion("TROLE_ID in", values, "troleId");
            return (Criteria) this;
        }

        public Criteria andTroleIdNotIn(List<String> values) {
            addCriterion("TROLE_ID not in", values, "troleId");
            return (Criteria) this;
        }

        public Criteria andTroleIdBetween(String value1, String value2) {
            addCriterion("TROLE_ID between", value1, value2, "troleId");
            return (Criteria) this;
        }

        public Criteria andTroleIdNotBetween(String value1, String value2) {
            addCriterion("TROLE_ID not between", value1, value2, "troleId");
            return (Criteria) this;
        }

        public Criteria orTroleIdIn(List<String> values) {
            orCriterion("TROLE_ID in", values, "troleId");
            return (Criteria) this;
        }

        public Criteria orTroleIdNotIn(List<String> values) {
            orCriterion("TROLE_ID not in", values, "troleId");
            return (Criteria) this;
        }

        public Criteria orTroleIdBetween(String value1, String value2) {
            orCriterion("TROLE_ID between", value1, value2, "troleId");
            return (Criteria) this;
        }

        public Criteria orTroleIdNotBetween(String value1, String value2) {
            orCriterion("TROLE_ID not between", value1, value2, "troleId");
            return (Criteria) this;
        }
        public Criteria andTresourceIdIsNull() {
            addCriterion("TRESOURCE_ID is null");
            return (Criteria) this;
        }
        
        public Criteria andTresourceIdIsNotNull() {
            addCriterion("TRESOURCE_ID is not null");
            return (Criteria) this;
        }
        public Criteria andTresourceIdEqualTo(String value) {
            addCriterion("TRESOURCE_ID =", value, "tresourceId");
            return (Criteria) this;
        }
        
        public Criteria andTresourceIdNotEqualTo(String value) {
            addCriterion("TRESOURCE_ID <>", value, "tresourceId");
            return (Criteria) this;
        }

        public Criteria andTresourceIdGreaterThan(String value) {
            addCriterion("TRESOURCE_ID >", value, "tresourceId");
            return (Criteria) this;
        }

        public Criteria andTresourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("TRESOURCE_ID >=", value, "tresourceId");
            return (Criteria) this;
        }

        public Criteria andTresourceIdLessThan(String value) {
            addCriterion("TRESOURCE_ID <", value, "tresourceId");
            return (Criteria) this;
        }

        public Criteria andTresourceIdLessThanOrEqualTo(String value) {
            addCriterion("TRESOURCE_ID <=", value, "tresourceId");
            return (Criteria) this;
        }
        public Criteria orTresourceIdIsNull() {
            orCriterion("TRESOURCE_ID is null");
            return (Criteria) this;
        }

        public Criteria orTresourceIdIsNotNull() {
            orCriterion("TRESOURCE_ID is not null");
            return (Criteria) this;
        }
        public Criteria orTresourceIdEqualTo(String value) {
            orCriterion("TRESOURCE_ID =", value, "tresourceId");
            return (Criteria) this;
        }

        public Criteria orTresourceIdNotEqualTo(String value) {
            orCriterion("TRESOURCE_ID <>", value, "tresourceId");
            return (Criteria) this;
        }

        public Criteria orTresourceIdGreaterThan(String value) {
            orCriterion("TRESOURCE_ID >", value, "tresourceId");
            return (Criteria) this;
        }

        public Criteria orTresourceIdGreaterThanOrEqualTo(String value) {
            orCriterion("TRESOURCE_ID >=", value, "tresourceId");
            return (Criteria) this;
        }

        public Criteria orTresourceIdLessThan(String value) {
            orCriterion("TRESOURCE_ID <", value, "tresourceId");
            return (Criteria) this;
        }

        public Criteria orTresourceIdLessThanOrEqualTo(String value) {
            orCriterion("TRESOURCE_ID <=", value, "tresourceId");
            return (Criteria) this;
        }
        public Criteria andTresourceIdLike(String value) {
            addCriterion("TRESOURCE_ID like", value, "tresourceId");
            return (Criteria) this;
        }

        public Criteria andTresourceIdNotLike(String value) {
            addCriterion("TRESOURCE_ID not like", value, "tresourceId");
            return (Criteria) this;
        }

        public Criteria orTresourceIdLike(String value) {
            orCriterion("TRESOURCE_ID like", value, "tresourceId");
            return (Criteria) this;
        }

        public Criteria orTresourceIdNotLike(String value) {
            orCriterion("TRESOURCE_ID not like", value, "tresourceId");
            return (Criteria) this;
        }
        
        
        public Criteria andTresourceIdIn(List<String> values) {
            addCriterion("TRESOURCE_ID in", values, "tresourceId");
            return (Criteria) this;
        }

        public Criteria andTresourceIdNotIn(List<String> values) {
            addCriterion("TRESOURCE_ID not in", values, "tresourceId");
            return (Criteria) this;
        }

        public Criteria andTresourceIdBetween(String value1, String value2) {
            addCriterion("TRESOURCE_ID between", value1, value2, "tresourceId");
            return (Criteria) this;
        }

        public Criteria andTresourceIdNotBetween(String value1, String value2) {
            addCriterion("TRESOURCE_ID not between", value1, value2, "tresourceId");
            return (Criteria) this;
        }

        public Criteria orTresourceIdIn(List<String> values) {
            orCriterion("TRESOURCE_ID in", values, "tresourceId");
            return (Criteria) this;
        }

        public Criteria orTresourceIdNotIn(List<String> values) {
            orCriterion("TRESOURCE_ID not in", values, "tresourceId");
            return (Criteria) this;
        }

        public Criteria orTresourceIdBetween(String value1, String value2) {
            orCriterion("TRESOURCE_ID between", value1, value2, "tresourceId");
            return (Criteria) this;
        }

        public Criteria orTresourceIdNotBetween(String value1, String value2) {
            orCriterion("TRESOURCE_ID not between", value1, value2, "tresourceId");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应数据库表 trole_tresource
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
     * 该类对应数据库表 trole_tresource
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