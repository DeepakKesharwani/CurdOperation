package jamocha;

public class StringValidator {

	public boolean stringValidator(String s)
	{
		for (int i = 0; i < s.length(); i++) 
		{
			if ((s.charAt(i) >= 65 && s.charAt(i) <= 90) || (s.charAt(i) >= 97 && s.charAt(i) <= 122)) {
		
			} else {
				return false;
			}
		}
		return true;
	}
	public boolean ageValidator(String s)
	{
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
			
			} else {
				return false;
			}
		}
		return true;
	}
	public boolean idValidator(String s) {
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)>=57 || s.charAt(i)<=48)
			{
				return false;
			}
		}
		
		return true;
	}

}
