package BEAN;

public class Variable {

		private String name,email,password,id,age,number,type,tag,imgname,fid,rid,rname,mid,messages,time,profilephoto;
		public String getRid() {
			return rid;
		}

		public void setRid(String rid) {
			this.rid = rid;
		}

		public String getRname() {
			return rname;
		}

		public void setRname(String rname) {
			this.rname = rname;
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getProfilephoto() {
			return profilephoto;
		}

		public void setProfilephoto(String profilephoto) {
			this.profilephoto = profilephoto;
		}

		public String getMessages() {
			return messages;
		}

		public void setMessages(String messages) {
			this.messages = messages;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		private long photos;
	    
		public String getTag() {
			return tag;
		}

		public void setTag(String tag) {
			this.tag = tag;
		}

		public String getFid() {
			return fid;
		}

		public void setFid(String fid) {
			this.fid = fid;
		}

		public String getImgname() {
			return imgname;
		}

		public void setImgname(String imgname) {
			this.imgname = imgname;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		@Override
		public String toString() {
			return "Variable [name=" + name + ", email=" + email + ", password=" + password + ", id=" + id + ", age=" + age
					+ ", number=" + number + ", type=" + type + ", tag=" + tag + ", imgname=" + imgname + ", fid=" + fid
					+ ", rid=" + rid + ", rname=" + rname + ", mid=" + mid + ", messages=" + messages + ", time=" + time
					+ ", photos=" + photos + "]";
		}
		
		

	}
	
	
	
