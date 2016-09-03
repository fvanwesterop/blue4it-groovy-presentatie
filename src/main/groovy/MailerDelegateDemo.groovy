
import groovy.transform.Canonical


class MailerDelegateDemo {

    	public void go() {
    		Mailer m = new Mailer()
			println m
    	}

    	public static void main(String[] argv) {
    		new MailerDelegateDemo().go()
    	}
}


class Mailer {

	private String from;
	private String to;
	private String subject;
	private String body;
	
	public String getFom(){
		return from;
	}

	public void setFom(String from){
		this.from = from;
	}

	public String getTo(){
		return to;
	}

	public void setTo(String to){
		this.to = to;
	}

	public String getSubject(){
		return subject;
	}

	public void setSubject(String subject){
		this.subject = subject;
	}

	public String getBody(){
		return body;
	}

	public void setBody(String body){
		this.body = body;
	}


}
