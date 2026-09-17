// Given a date string in the form Day Month Year, where:
// Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
// Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
// Year is in the range [1900, 2100].
// Convert the date string to the format YYYY-MM-DD, where:
// YYYY denotes the 4 digit year.
// MM denotes the 2 digit month.
// DD denotes the 2 digit day.
 

// Example 1:
// Input: date = "20th Oct 2052"
// Output: "2052-10-20"

// Example 2:
// Input: date = "6th Jun 1933"
// Output: "1933-06-06"

// Example 3:
// Input: date = "26th May 1960"
// Output: "1960-05-26"
 

// Constraints:
// The given dates are guaranteed to be valid, so no error handling is necessary.



class Reformat Date{
    public String reformatDate(String date) {
        String months[]={"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        StringBuilder sb=new StringBuilder();
        String[]s=date.split(" ");
        sb.append(s[2]);
        sb.append("-");
        int count=1;
        for(int i=0;i<months.length;i++){
            if(!months[i].equals(s[1])){
                count++;
            }else{
                break;
            }
        }
        if(count<10){sb.append("0");sb.append(count); sb.append("-");}
        else{sb.append(count);sb.append("-");}
        String d="";
        String a=s[0];
        for(char ch:a.toCharArray()){
            if('0'<=ch && '9'>=ch){
                d+=ch;
            }
        }
        if(Integer.parseInt(d)<10){sb.append("0");sb.append(d);}
        else{sb.append(d);}
        return sb.toString();
    }
}