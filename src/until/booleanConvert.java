package until;

public class booleanConvert
{
    public static String boolValue (Boolean isComplete)
    {

        String bV = "null";

        if (isComplete == true)
        {
            bV = "Yes";
        }
        else
        {
            bV = "No";
        }


        return bV;
    }
}
