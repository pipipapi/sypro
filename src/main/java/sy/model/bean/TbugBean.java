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

public class TbugBean {
    /**
     * order by 排序语句
     * 对应数据库表字段 tbug
     */
    private List<Order> orderBy;

    /**
     * 分页开始记录
     * 对应数据库表字段 tbug
     */
    private Integer pageIndex;

    /**
     * 分页大小
     * 对应数据库表字段 tbug
     */
    private int pageSize = 10;

    /**
     * 是否指定 distinct 去除重复
     * 对应数据库表字段 tbug
     */
    private boolean distinct;

    /**
     * 逻辑or语句
     * 对应数据库表字段 tbug
     */
    private List<Criteria> oredCriteria;

    /**
     */
    public TbugBean() {
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
     * 该类对应数据库表 tbug
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
        public Criteria andNoteIsNull() {
            addCriterion("NOTE is null");
            return (Criteria) this;
        }
        
        public Criteria andNoteIsNotNull() {
            addCriterion("NOTE is not null");
            return (Criteria) this;
        }
        public Criteria andNoteEqualTo(String value) {
            addCriterion("NOTE =", value, "note");
            return (Criteria) this;
        }
        
        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("NOTE <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("NOTE >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("NOTE >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("NOTE <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("NOTE <=", value, "note");
            return (Criteria) this;
        }
        public Criteria orNoteIsNull() {
            orCriterion("NOTE is null");
            return (Criteria) this;
        }

        public Criteria orNoteIsNotNull() {
            orCriterion("NOTE is not null");
            return (Criteria) this;
        }
        public Criteria orNoteEqualTo(String value) {
            orCriterion("NOTE =", value, "note");
            return (Criteria) this;
        }

        public Criteria orNoteNotEqualTo(String value) {
            orCriterion("NOTE <>", value, "note");
            return (Criteria) this;
        }

        public Criteria orNoteGreaterThan(String value) {
            orCriterion("NOTE >", value, "note");
            return (Criteria) this;
        }

        public Criteria orNoteGreaterThanOrEqualTo(String value) {
            orCriterion("NOTE >=", value, "note");
            return (Criteria) this;
        }

        public Criteria orNoteLessThan(String value) {
            orCriterion("NOTE <", value, "note");
            return (Criteria) this;
        }

        public Criteria orNoteLessThanOrEqualTo(String value) {
            orCriterion("NOTE <=", value, "note");
            return (Criteria) this;
        }
        public Criteria andNoteLike(String value) {
            addCriterion("NOTE like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("NOTE not like", value, "note");
            return (Criteria) this;
        }

        public Criteria orNoteLike(String value) {
            orCriterion("NOTE like", value, "note");
            return (Criteria) this;
        }

        public Criteria orNoteNotLike(String value) {
            orCriterion("NOTE not like", value, "note");
            return (Criteria) this;
        }
        
        
        public Criteria andNoteIn(List<String> values) {
            addCriterion("NOTE in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("NOTE not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("NOTE between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("NOTE not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria orNoteIn(List<String> values) {
            orCriterion("NOTE in", values, "note");
            return (Criteria) this;
        }

        public Criteria orNoteNotIn(List<String> values) {
            orCriterion("NOTE not in", values, "note");
            return (Criteria) this;
        }

        public Criteria orNoteBetween(String value1, String value2) {
            orCriterion("NOTE between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria orNoteNotBetween(String value1, String value2) {
            orCriterion("NOTE not between", value1, value2, "note");
            return (Criteria) this;
        }
        public Criteria andBugtypeIdIsNull() {
            addCriterion("BUGTYPE_ID is null");
            return (Criteria) this;
        }
        
        public Criteria andBugtypeIdIsNotNull() {
            addCriterion("BUGTYPE_ID is not null");
            return (Criteria) this;
        }
        public Criteria andBugtypeIdEqualTo(String value) {
            addCriterion("BUGTYPE_ID =", value, "bugtypeId");
            return (Criteria) this;
        }
        
        public Criteria andBugtypeIdNotEqualTo(String value) {
            addCriterion("BUGTYPE_ID <>", value, "bugtypeId");
            return (Criteria) this;
        }

        public Criteria andBugtypeIdGreaterThan(String value) {
            addCriterion("BUGTYPE_ID >", value, "bugtypeId");
            return (Criteria) this;
        }

        public Criteria andBugtypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("BUGTYPE_ID >=", value, "bugtypeId");
            return (Criteria) this;
        }

        public Criteria andBugtypeIdLessThan(String value) {
            addCriterion("BUGTYPE_ID <", value, "bugtypeId");
            return (Criteria) this;
        }

        public Criteria andBugtypeIdLessThanOrEqualTo(String value) {
            addCriterion("BUGTYPE_ID <=", value, "bugtypeId");
            return (Criteria) this;
        }
        public Criteria orBugtypeIdIsNull() {
            orCriterion("BUGTYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria orBugtypeIdIsNotNull() {
            orCriterion("BUGTYPE_ID is not null");
            return (Criteria) this;
        }
        public Criteria orBugtypeIdEqualTo(String value) {
            orCriterion("BUGTYPE_ID =", value, "bugtypeId");
            return (Criteria) this;
        }

        public Criteria orBugtypeIdNotEqualTo(String value) {
            orCriterion("BUGTYPE_ID <>", value, "bugtypeId");
            return (Criteria) this;
        }

        public Criteria orBugtypeIdGreaterThan(String value) {
            orCriterion("BUGTYPE_ID >", value, "bugtypeId");
            return (Criteria) this;
        }

        public Criteria orBugtypeIdGreaterThanOrEqualTo(String value) {
            orCriterion("BUGTYPE_ID >=", value, "bugtypeId");
            return (Criteria) this;
        }

        public Criteria orBugtypeIdLessThan(String value) {
            orCriterion("BUGTYPE_ID <", value, "bugtypeId");
            return (Criteria) this;
        }

        public Criteria orBugtypeIdLessThanOrEqualTo(String value) {
            orCriterion("BUGTYPE_ID <=", value, "bugtypeId");
            return (Criteria) this;
        }
        public Criteria andBugtypeIdLike(String value) {
            addCriterion("BUGTYPE_ID like", value, "bugtypeId");
            return (Criteria) this;
        }

        public Criteria andBugtypeIdNotLike(String value) {
            addCriterion("BUGTYPE_ID not like", value, "bugtypeId");
            return (Criteria) this;
        }

        public Criteria orBugtypeIdLike(String value) {
            orCriterion("BUGTYPE_ID like", value, "bugtypeId");
            return (Criteria) this;
        }

        public Criteria orBugtypeIdNotLike(String value) {
            orCriterion("BUGTYPE_ID not like", value, "bugtypeId");
            return (Criteria) this;
        }
        
        
        public Criteria andBugtypeIdIn(List<String> values) {
            addCriterion("BUGTYPE_ID in", values, "bugtypeId");
            return (Criteria) this;
        }

        public Criteria andBugtypeIdNotIn(List<String> values) {
            addCriterion("BUGTYPE_ID not in", values, "bugtypeId");
            return (Criteria) this;
        }

        public Criteria andBugtypeIdBetween(String value1, String value2) {
            addCriterion("BUGTYPE_ID between", value1, value2, "bugtypeId");
            return (Criteria) this;
        }

        public Criteria andBugtypeIdNotBetween(String value1, String value2) {
            addCriterion("BUGTYPE_ID not between", value1, value2, "bugtypeId");
            return (Criteria) this;
        }

        public Criteria orBugtypeIdIn(List<String> values) {
            orCriterion("BUGTYPE_ID in", values, "bugtypeId");
            return (Criteria) this;
        }

        public Criteria orBugtypeIdNotIn(List<String> values) {
            orCriterion("BUGTYPE_ID not in", values, "bugtypeId");
            return (Criteria) this;
        }

        public Criteria orBugtypeIdBetween(String value1, String value2) {
            orCriterion("BUGTYPE_ID between", value1, value2, "bugtypeId");
            return (Criteria) this;
        }

        public Criteria orBugtypeIdNotBetween(String value1, String value2) {
            orCriterion("BUGTYPE_ID not between", value1, value2, "bugtypeId");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应数据库表 tbug
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
     * 该类对应数据库表 tbug
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