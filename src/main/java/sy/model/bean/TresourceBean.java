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

public class TresourceBean {
    /**
     * order by 排序语句
     * 对应数据库表字段 tresource
     */
    private List<Order> orderBy;

    /**
     * 分页开始记录
     * 对应数据库表字段 tresource
     */
    private Integer pageIndex;

    /**
     * 分页大小
     * 对应数据库表字段 tresource
     */
    private int pageSize = 10;

    /**
     * 是否指定 distinct 去除重复
     * 对应数据库表字段 tresource
     */
    private boolean distinct;

    /**
     * 逻辑or语句
     * 对应数据库表字段 tresource
     */
    private List<Criteria> oredCriteria;

    /**
     */
    public TresourceBean() {
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
     * 该类对应数据库表 tresource
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
        public Criteria andIconIsNull() {
            addCriterion("ICON is null");
            return (Criteria) this;
        }
        
        public Criteria andIconIsNotNull() {
            addCriterion("ICON is not null");
            return (Criteria) this;
        }
        public Criteria andIconEqualTo(String value) {
            addCriterion("ICON =", value, "icon");
            return (Criteria) this;
        }
        
        public Criteria andIconNotEqualTo(String value) {
            addCriterion("ICON <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("ICON >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("ICON >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("ICON <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("ICON <=", value, "icon");
            return (Criteria) this;
        }
        public Criteria orIconIsNull() {
            orCriterion("ICON is null");
            return (Criteria) this;
        }

        public Criteria orIconIsNotNull() {
            orCriterion("ICON is not null");
            return (Criteria) this;
        }
        public Criteria orIconEqualTo(String value) {
            orCriterion("ICON =", value, "icon");
            return (Criteria) this;
        }

        public Criteria orIconNotEqualTo(String value) {
            orCriterion("ICON <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria orIconGreaterThan(String value) {
            orCriterion("ICON >", value, "icon");
            return (Criteria) this;
        }

        public Criteria orIconGreaterThanOrEqualTo(String value) {
            orCriterion("ICON >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria orIconLessThan(String value) {
            orCriterion("ICON <", value, "icon");
            return (Criteria) this;
        }

        public Criteria orIconLessThanOrEqualTo(String value) {
            orCriterion("ICON <=", value, "icon");
            return (Criteria) this;
        }
        public Criteria andIconLike(String value) {
            addCriterion("ICON like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("ICON not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria orIconLike(String value) {
            orCriterion("ICON like", value, "icon");
            return (Criteria) this;
        }

        public Criteria orIconNotLike(String value) {
            orCriterion("ICON not like", value, "icon");
            return (Criteria) this;
        }
        
        
        public Criteria andIconIn(List<String> values) {
            addCriterion("ICON in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("ICON not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("ICON between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("ICON not between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria orIconIn(List<String> values) {
            orCriterion("ICON in", values, "icon");
            return (Criteria) this;
        }

        public Criteria orIconNotIn(List<String> values) {
            orCriterion("ICON not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria orIconBetween(String value1, String value2) {
            orCriterion("ICON between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria orIconNotBetween(String value1, String value2) {
            orCriterion("ICON not between", value1, value2, "icon");
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
        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }
        
        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }
        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }
        
        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }
        public Criteria orRemarkIsNull() {
            orCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria orRemarkIsNotNull() {
            orCriterion("REMARK is not null");
            return (Criteria) this;
        }
        public Criteria orRemarkEqualTo(String value) {
            orCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkNotEqualTo(String value) {
            orCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkGreaterThan(String value) {
            orCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkGreaterThanOrEqualTo(String value) {
            orCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkLessThan(String value) {
            orCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkLessThanOrEqualTo(String value) {
            orCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }
        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkLike(String value) {
            orCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkNotLike(String value) {
            orCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }
        
        
        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkIn(List<String> values) {
            orCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkNotIn(List<String> values) {
            orCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkBetween(String value1, String value2) {
            orCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria orRemarkNotBetween(String value1, String value2) {
            orCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }
        public Criteria andSeqIsNull() {
            addCriterion("SEQ is null");
            return (Criteria) this;
        }
        
        public Criteria andSeqIsNotNull() {
            addCriterion("SEQ is not null");
            return (Criteria) this;
        }
        public Criteria andSeqEqualTo(Integer value) {
            addCriterion("SEQ =", value, "seq");
            return (Criteria) this;
        }
        
        public Criteria andSeqNotEqualTo(Integer value) {
            addCriterion("SEQ <>", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThan(Integer value) {
            addCriterion("SEQ >", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEQ >=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThan(Integer value) {
            addCriterion("SEQ <", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThanOrEqualTo(Integer value) {
            addCriterion("SEQ <=", value, "seq");
            return (Criteria) this;
        }
        public Criteria orSeqIsNull() {
            orCriterion("SEQ is null");
            return (Criteria) this;
        }

        public Criteria orSeqIsNotNull() {
            orCriterion("SEQ is not null");
            return (Criteria) this;
        }
        public Criteria orSeqEqualTo(Integer value) {
            orCriterion("SEQ =", value, "seq");
            return (Criteria) this;
        }

        public Criteria orSeqNotEqualTo(Integer value) {
            orCriterion("SEQ <>", value, "seq");
            return (Criteria) this;
        }

        public Criteria orSeqGreaterThan(Integer value) {
            orCriterion("SEQ >", value, "seq");
            return (Criteria) this;
        }

        public Criteria orSeqGreaterThanOrEqualTo(Integer value) {
            orCriterion("SEQ >=", value, "seq");
            return (Criteria) this;
        }

        public Criteria orSeqLessThan(Integer value) {
            orCriterion("SEQ <", value, "seq");
            return (Criteria) this;
        }

        public Criteria orSeqLessThanOrEqualTo(Integer value) {
            orCriterion("SEQ <=", value, "seq");
            return (Criteria) this;
        }
        
        
        public Criteria andSeqIn(List<Integer> values) {
            addCriterion("SEQ in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotIn(List<Integer> values) {
            addCriterion("SEQ not in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqBetween(Integer value1, Integer value2) {
            addCriterion("SEQ between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("SEQ not between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria orSeqIn(List<Integer> values) {
            orCriterion("SEQ in", values, "seq");
            return (Criteria) this;
        }

        public Criteria orSeqNotIn(List<Integer> values) {
            orCriterion("SEQ not in", values, "seq");
            return (Criteria) this;
        }

        public Criteria orSeqBetween(Integer value1, Integer value2) {
            orCriterion("SEQ between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria orSeqNotBetween(Integer value1, Integer value2) {
            orCriterion("SEQ not between", value1, value2, "seq");
            return (Criteria) this;
        }
        public Criteria andUrlIsNull() {
            addCriterion("URL is null");
            return (Criteria) this;
        }
        
        public Criteria andUrlIsNotNull() {
            addCriterion("URL is not null");
            return (Criteria) this;
        }
        public Criteria andUrlEqualTo(String value) {
            addCriterion("URL =", value, "url");
            return (Criteria) this;
        }
        
        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("URL <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("URL >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("URL >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("URL <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("URL <=", value, "url");
            return (Criteria) this;
        }
        public Criteria orUrlIsNull() {
            orCriterion("URL is null");
            return (Criteria) this;
        }

        public Criteria orUrlIsNotNull() {
            orCriterion("URL is not null");
            return (Criteria) this;
        }
        public Criteria orUrlEqualTo(String value) {
            orCriterion("URL =", value, "url");
            return (Criteria) this;
        }

        public Criteria orUrlNotEqualTo(String value) {
            orCriterion("URL <>", value, "url");
            return (Criteria) this;
        }

        public Criteria orUrlGreaterThan(String value) {
            orCriterion("URL >", value, "url");
            return (Criteria) this;
        }

        public Criteria orUrlGreaterThanOrEqualTo(String value) {
            orCriterion("URL >=", value, "url");
            return (Criteria) this;
        }

        public Criteria orUrlLessThan(String value) {
            orCriterion("URL <", value, "url");
            return (Criteria) this;
        }

        public Criteria orUrlLessThanOrEqualTo(String value) {
            orCriterion("URL <=", value, "url");
            return (Criteria) this;
        }
        public Criteria andUrlLike(String value) {
            addCriterion("URL like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("URL not like", value, "url");
            return (Criteria) this;
        }

        public Criteria orUrlLike(String value) {
            orCriterion("URL like", value, "url");
            return (Criteria) this;
        }

        public Criteria orUrlNotLike(String value) {
            orCriterion("URL not like", value, "url");
            return (Criteria) this;
        }
        
        
        public Criteria andUrlIn(List<String> values) {
            addCriterion("URL in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("URL not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("URL between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("URL not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria orUrlIn(List<String> values) {
            orCriterion("URL in", values, "url");
            return (Criteria) this;
        }

        public Criteria orUrlNotIn(List<String> values) {
            orCriterion("URL not in", values, "url");
            return (Criteria) this;
        }

        public Criteria orUrlBetween(String value1, String value2) {
            orCriterion("URL between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria orUrlNotBetween(String value1, String value2) {
            orCriterion("URL not between", value1, value2, "url");
            return (Criteria) this;
        }
        public Criteria andPidIsNull() {
            addCriterion("PID is null");
            return (Criteria) this;
        }
        
        public Criteria andPidIsNotNull() {
            addCriterion("PID is not null");
            return (Criteria) this;
        }
        public Criteria andPidEqualTo(String value) {
            addCriterion("PID =", value, "pid");
            return (Criteria) this;
        }
        
        public Criteria andPidNotEqualTo(String value) {
            addCriterion("PID <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("PID >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("PID >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("PID <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("PID <=", value, "pid");
            return (Criteria) this;
        }
        public Criteria orPidIsNull() {
            orCriterion("PID is null");
            return (Criteria) this;
        }

        public Criteria orPidIsNotNull() {
            orCriterion("PID is not null");
            return (Criteria) this;
        }
        public Criteria orPidEqualTo(String value) {
            orCriterion("PID =", value, "pid");
            return (Criteria) this;
        }

        public Criteria orPidNotEqualTo(String value) {
            orCriterion("PID <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria orPidGreaterThan(String value) {
            orCriterion("PID >", value, "pid");
            return (Criteria) this;
        }

        public Criteria orPidGreaterThanOrEqualTo(String value) {
            orCriterion("PID >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria orPidLessThan(String value) {
            orCriterion("PID <", value, "pid");
            return (Criteria) this;
        }

        public Criteria orPidLessThanOrEqualTo(String value) {
            orCriterion("PID <=", value, "pid");
            return (Criteria) this;
        }
        public Criteria andPidLike(String value) {
            addCriterion("PID like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("PID not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria orPidLike(String value) {
            orCriterion("PID like", value, "pid");
            return (Criteria) this;
        }

        public Criteria orPidNotLike(String value) {
            orCriterion("PID not like", value, "pid");
            return (Criteria) this;
        }
        
        
        public Criteria andPidIn(List<String> values) {
            addCriterion("PID in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("PID not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("PID between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("PID not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria orPidIn(List<String> values) {
            orCriterion("PID in", values, "pid");
            return (Criteria) this;
        }

        public Criteria orPidNotIn(List<String> values) {
            orCriterion("PID not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria orPidBetween(String value1, String value2) {
            orCriterion("PID between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria orPidNotBetween(String value1, String value2) {
            orCriterion("PID not between", value1, value2, "pid");
            return (Criteria) this;
        }
        public Criteria andTresourcetypeIdIsNull() {
            addCriterion("TRESOURCETYPE_ID is null");
            return (Criteria) this;
        }
        
        public Criteria andTresourcetypeIdIsNotNull() {
            addCriterion("TRESOURCETYPE_ID is not null");
            return (Criteria) this;
        }
        public Criteria andTresourcetypeIdEqualTo(String value) {
            addCriterion("TRESOURCETYPE_ID =", value, "tresourcetypeId");
            return (Criteria) this;
        }
        
        public Criteria andTresourcetypeIdNotEqualTo(String value) {
            addCriterion("TRESOURCETYPE_ID <>", value, "tresourcetypeId");
            return (Criteria) this;
        }

        public Criteria andTresourcetypeIdGreaterThan(String value) {
            addCriterion("TRESOURCETYPE_ID >", value, "tresourcetypeId");
            return (Criteria) this;
        }

        public Criteria andTresourcetypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("TRESOURCETYPE_ID >=", value, "tresourcetypeId");
            return (Criteria) this;
        }

        public Criteria andTresourcetypeIdLessThan(String value) {
            addCriterion("TRESOURCETYPE_ID <", value, "tresourcetypeId");
            return (Criteria) this;
        }

        public Criteria andTresourcetypeIdLessThanOrEqualTo(String value) {
            addCriterion("TRESOURCETYPE_ID <=", value, "tresourcetypeId");
            return (Criteria) this;
        }
        public Criteria orTresourcetypeIdIsNull() {
            orCriterion("TRESOURCETYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria orTresourcetypeIdIsNotNull() {
            orCriterion("TRESOURCETYPE_ID is not null");
            return (Criteria) this;
        }
        public Criteria orTresourcetypeIdEqualTo(String value) {
            orCriterion("TRESOURCETYPE_ID =", value, "tresourcetypeId");
            return (Criteria) this;
        }

        public Criteria orTresourcetypeIdNotEqualTo(String value) {
            orCriterion("TRESOURCETYPE_ID <>", value, "tresourcetypeId");
            return (Criteria) this;
        }

        public Criteria orTresourcetypeIdGreaterThan(String value) {
            orCriterion("TRESOURCETYPE_ID >", value, "tresourcetypeId");
            return (Criteria) this;
        }

        public Criteria orTresourcetypeIdGreaterThanOrEqualTo(String value) {
            orCriterion("TRESOURCETYPE_ID >=", value, "tresourcetypeId");
            return (Criteria) this;
        }

        public Criteria orTresourcetypeIdLessThan(String value) {
            orCriterion("TRESOURCETYPE_ID <", value, "tresourcetypeId");
            return (Criteria) this;
        }

        public Criteria orTresourcetypeIdLessThanOrEqualTo(String value) {
            orCriterion("TRESOURCETYPE_ID <=", value, "tresourcetypeId");
            return (Criteria) this;
        }
        public Criteria andTresourcetypeIdLike(String value) {
            addCriterion("TRESOURCETYPE_ID like", value, "tresourcetypeId");
            return (Criteria) this;
        }

        public Criteria andTresourcetypeIdNotLike(String value) {
            addCriterion("TRESOURCETYPE_ID not like", value, "tresourcetypeId");
            return (Criteria) this;
        }

        public Criteria orTresourcetypeIdLike(String value) {
            orCriterion("TRESOURCETYPE_ID like", value, "tresourcetypeId");
            return (Criteria) this;
        }

        public Criteria orTresourcetypeIdNotLike(String value) {
            orCriterion("TRESOURCETYPE_ID not like", value, "tresourcetypeId");
            return (Criteria) this;
        }
        
        
        public Criteria andTresourcetypeIdIn(List<String> values) {
            addCriterion("TRESOURCETYPE_ID in", values, "tresourcetypeId");
            return (Criteria) this;
        }

        public Criteria andTresourcetypeIdNotIn(List<String> values) {
            addCriterion("TRESOURCETYPE_ID not in", values, "tresourcetypeId");
            return (Criteria) this;
        }

        public Criteria andTresourcetypeIdBetween(String value1, String value2) {
            addCriterion("TRESOURCETYPE_ID between", value1, value2, "tresourcetypeId");
            return (Criteria) this;
        }

        public Criteria andTresourcetypeIdNotBetween(String value1, String value2) {
            addCriterion("TRESOURCETYPE_ID not between", value1, value2, "tresourcetypeId");
            return (Criteria) this;
        }

        public Criteria orTresourcetypeIdIn(List<String> values) {
            orCriterion("TRESOURCETYPE_ID in", values, "tresourcetypeId");
            return (Criteria) this;
        }

        public Criteria orTresourcetypeIdNotIn(List<String> values) {
            orCriterion("TRESOURCETYPE_ID not in", values, "tresourcetypeId");
            return (Criteria) this;
        }

        public Criteria orTresourcetypeIdBetween(String value1, String value2) {
            orCriterion("TRESOURCETYPE_ID between", value1, value2, "tresourcetypeId");
            return (Criteria) this;
        }

        public Criteria orTresourcetypeIdNotBetween(String value1, String value2) {
            orCriterion("TRESOURCETYPE_ID not between", value1, value2, "tresourcetypeId");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应数据库表 tresource
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
     * 该类对应数据库表 tresource
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