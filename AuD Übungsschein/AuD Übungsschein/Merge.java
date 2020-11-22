public class Merge {

    public static long[] merge(long[] ns, int i, Merger m)
    {
    	// call m.merge as requested by exercise
        m.merge();
        // if the indexer is negative we skip to the first valid
        // index which is 0 
        if(i < 0)
            return merge(ns,0, m);

        long[] validValues = new long[0];
        // trim values which are before the passed index {3, 4, 5, 5, 6} with i = 1
        // will result in {4, 5, 5, 6}
        for(int counter = i; counter < ns.length; counter++)
        {
            validValues = m.append(validValues, ns[counter]);
        }
        // if there are no values to process just return the empty list
        if(validValues.length == 0)
            return validValues;

        // call ourselves with an index of one so the next iteration will skip 
        // our first number until we reach the end of the list
        long[] mergeResult = merge(validValues, 1, m);
        // if we already passed one recursion we will check our first value in
        // the list with the one after if we match, the first value in our result
        // will have to be multiplied by our current value
        if(mergeResult.length > 0 && validValues[0] == validValues[1])
            mergeResult[0] = mergeResult[0] * validValues[0];
        // otherwise we add our value at the start of the result list so
        // the next iteration can multiply it if necessary
        else
            mergeResult = m.prepend(validValues[0], mergeResult);

        return mergeResult;
    }
}