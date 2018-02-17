package sy.model;

import com.dap.dao.BasePo;

import java.util.HashSet;
import java.util.Set;

public class Trole extends BasePo {

	private String id;
	private Trole trole;
	private String name;
	private String remark;
	private Integer seq;
	private Set<Trole> troles = new HashSet<Trole>(0);
	private Set<Tresource> tresources = new HashSet<Tresource>(0);
	private Set<Tuser> tusers = new HashSet<Tuser>(0);

	public Trole() {
	}

	public Trole(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public Trole(String id, Trole trole, String name, String remark, Integer seq, Set<Trole> troles, Set<Tresource> tresources, Set<Tuser> tusers) {
		this.id = id;
		this.trole = trole;
		this.name = name;
		this.remark = remark;
		this.seq = seq;
		this.troles = troles;
		this.tresources = tresources;
		this.tusers = tusers;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Trole getTrole() {
		return this.trole;
	}

	public void setTrole(Trole trole) {
		this.trole = trole;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Set<Trole> getTroles() {
		return this.troles;
	}

	public void setTroles(Set<Trole> troles) {
		this.troles = troles;
	}

	public Set<Tresource> getTresources() {
		return this.tresources;
	}

	public void setTresources(Set<Tresource> tresources) {
		this.tresources = tresources;
	}

	public Set<Tuser> getTusers() {
		return this.tusers;
	}

	public void setTusers(Set<Tuser> tusers) {
		this.tusers = tusers;
	}

}
