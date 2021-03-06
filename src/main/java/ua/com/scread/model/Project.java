package ua.com.scread.model;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="projects_id_seq")
    @SequenceGenerator(name="projects_id_seq", sequenceName="projects_id_seq", allocationSize=1)
	private int id;
	
	private String name;
	private String description;

	@Column(name = "money_need")
	private int moneyNeed;

	@Column(name = "money_has")
	private int moneyHas;
	
	@Column(name = "days_left")
	private int daysLeft;

	private String history;
	
	@Column(name = "video_link")
	private String videoLink;

	@Column(name = "question")
	private String questions;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false, insertable = true, updatable = false)
	private Category category;

	public Project() {
	}

	public Project(Category category) {
		this.category = category;
	}

	public Project(int id, Category category) {
		this.id = id;
		this.category = category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMoneyNeed(int moneyNeed) {
		this.moneyNeed = moneyNeed;
	}

	public void setMoneyHas(int moneyHas) {
		this.moneyHas = moneyHas;
	}

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getMoneyNeed() {
		return moneyNeed;
	}

	public void increaseMoneyHas(int moneyHas) {
		this.moneyHas += moneyHas;
	}

	public int getMoneyHas() {
		return moneyHas;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public String getHistory() {
		return history;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public String getQuestion() {
		return questions;
	}

	public void addClientQuestion(String question) {
		questions += "\nQ: " + question;
	}

	public String informForNoBonuses(String bonus) {
		return bonus != null ? bonus : "nothing=(";
	}
	
	@Override
	public String toString() {
		return "Project [nameOfProject=" + name + ", description="
				+ description + ", moneyNeed=" + moneyNeed + ", moneyHas="
				+ moneyHas + ", daysLeft=" + daysLeft + ", category="
				+ category + ", history=" + history + ", videoLink="
				+ videoLink + ", questions=" + questions + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
