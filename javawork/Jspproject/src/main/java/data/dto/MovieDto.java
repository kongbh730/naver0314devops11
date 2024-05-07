package data.dto;

//import java.sql.Timestamp;

public class MovieDto 
{ 
	private int num;
	private String title;
	private String poster;
	private String announcementyoutube;
	private String genre;
	private String introduce;
	private String director;
	private String actors;
	//private Timestamp releaseday;

	public MovieDto() {
		super();
	}

	public MovieDto(int num, String title, String poster, String announcementyoutube, String genre, String introduce, String director,
			String actors/*, Timestamp releaseday*/) {
		super();
		this.num = num;
		this.title = title;
		this.poster = poster;
		this.announcementyoutube = announcementyoutube;
		this.genre = genre;
		this.introduce = introduce;
		this.director = director;
		this.actors = actors;
		//this.releaseday = releaseday;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getAnnouncementyoutube() {
		return announcementyoutube;
	}
	public void setAnnouncementyoutube(String announcementyoutube) {
		this.announcementyoutube = announcementyoutube;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	/*
	public Timestamp getReleaseday() {
		return releaseday;
	}
	public void setReleaseday(Timestamp releaseday) {
		this.releaseday = releaseday;
	}
	*/
}