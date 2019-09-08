package jamocha;

	import java.text.DateFormat;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;

	public class DateValidator
	{
			public boolean isThisDateValid(String date){
	        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");

	        // Input to be parsed should strictly follow the defined date format
	        // above.
	        format.setLenient(false);

	           try {
	            format.parse(date);
	        } catch (ParseException e) {
	            System.out.println("Date " + date + " is not valid according to " +
	                ((SimpleDateFormat) format).toPattern() + " pattern.");
	            return false;
	        }
	           return true;
	    }

}
