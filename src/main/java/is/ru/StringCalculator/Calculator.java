package is.ru.StringCalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		if(numbers.startsWith("//\n")){
				String ret = numbers.replace("//\n\n", "");
				return	ret.split("\n");
		}
		else if(numbers.startsWith("//")){
			String ret = "";
			numbers = numbers.replaceAll("\\*", "a");
			if(numbers.startsWith("//[")){
				numbers = numbers.replace("//[", "");
				String[] delimiter = numbers.split("]", 2);
				String del = delimiter[0];
				ret = delimiter[1].replaceFirst("\n", "").replaceAll(del, ",");
				if(ret.startsWith("[")){
					ret = ret.replace("[", "");
					String[] delimiter2 = ret.split("]", 2);
					String del2 = delimiter2[0];
					ret = ret.replace("]", "").replaceAll(del2, ",");
				}	
			}
			else{
				String[] splitted = numbers.split("\n", 2);
				String[] del = splitted[0].split("");
				String delimiter = del[2];
				ret = splitted[1].replaceAll(delimiter, ",");
			}
			return ret.split(",");
		}
		else{
			return numbers.split(",|\n");
		}	
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
 	    String fail = "“Negatives not allowed: ";
 	    int checker = 0;
        for(String number : numbers){
        	if(!number.equals("")){
	        	int sum = toInt(number);
	        	if(sum < 0){
	        		if(checker > 0){
	        			fail += ", ";
	        		}
	        		fail += sum;
	        		checker++;
	        	}
	        	else if(sum <= 1000){
			    	total += sum;
				}
			}
		}
		if(checker > 0){
			throw new IllegalArgumentException(fail);
		}
		return total;
    }



}