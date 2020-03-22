public class ParsingEDIFACT {

    public static void  main(String arg[]) {

        String EDIFACT = "UNA:+.? '" +
                "UNB+UNOC:3+2021000969+4441963198+180525:1225+3VAL2MJV6EH9IX+KMSV7HMD+CUSDECU-IE++1++1'" +
                "UNH+EDIFACT+CUSDEC:D:96B:UN:145050'" +
                "BGM+ZEM:::EX+09SEE7JPUV5HC06IC6+Z'" +
                "LOC+17+IT044100'" +
                "LOC+18+SOL'" +
                "LOC+35+SE'" +
                "LOC+36+TZ'" +
                "LOC+116+SE003033'" +
                "DTM+9:20090527:102'" +
                "DTM+268:20090626:102'" +
                "DTM+182:20090527:102'";

        //Split EDIFACT by the final segment terminator  \'
        String[] line = EDIFACT.split("\'");


        for(String a: line ){
            // Split the segment on the + .  Note: + is a reserved character in regexes, so use \\+
            String[] seg = a.split("\\+");
            //Fetch for segments with LOC
            if(seg[0].equals("LOC")){
                System.out.println(seg[1] + " " + seg[2]);
            }
        }

    }
}
