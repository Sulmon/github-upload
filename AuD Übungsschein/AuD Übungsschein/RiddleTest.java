//import org.junit.Test; //need to comment out for submission

public class RiddleTest {

    private static final RiddleType DEFAULT_RIDDLE_TYPE = RiddleType.ADD;
    // ################ Tests 4 RiddleNode

    @Test
    public void testConstructor(){
        int value = 1;
        boolean result = false;
        RiddleNode testNode = new RiddleNode(DEFAULT_RIDDLE_TYPE, value, result);
        Assert.assertEquals("Wrong riddle type", DEFAULT_RIDDLE_TYPE, testNode.type);
        Assert.assertEquals("Wrong riddle value", value, testNode.value);
        Assert.assertEquals("Wrong riddle result", result, testNode.result);
    }

    @Test
    public void testToStringNone(){
        int value = 1;
        boolean result = false;
        RiddleNode testNode = new RiddleNode(DEFAULT_RIDDLE_TYPE, value, result);

        String string = testNode.toString();

        Assert.assertEquals("toString broken!", "[ADD]", string);
    }

    @Test
    public void testToStringResult(){
        int value = 1;
        boolean result = true;
        RiddleNode testNode = new RiddleNode(DEFAULT_RIDDLE_TYPE, value, result);

        String string = testNode.toString();

        Assert.assertEquals("toString broken!", "[ADD:#]", string);
    }

    @Test
    public void testToStringType(){
        int value = 1;
        boolean result = false;
        RiddleNode testNode = new RiddleNode(RiddleType.VAL, value, result);

        String string = testNode.toString();

        Assert.assertEquals("toString broken!", "[VAL:1]", string);
    }

    @Test
    public void testToStringBoth(){
        int value = 1;
        boolean result = true;
        RiddleNode testNode = new RiddleNode(RiddleType.VAL, value, result);

        String string = testNode.toString();

        Assert.assertEquals("toString broken!", "[VAL:1:#]", string);
    }

    @Test
    public void testSetNeighbours_happyPath(){
        int value = 1;
        boolean result = true;
        RiddleNode testNode = new RiddleNode(RiddleType.VAL, value, result);

        testNode.setNeighbours(testNode, testNode);

        RiddleNode[] neighbours = testNode.getNeighbours();
        for (int i = 0; i <neighbours.length; i++) {
            Assert.assertEquals("ineighbours were not set properly", neighbours[i], i<2 ? testNode : null);
        }
    }

    @Test
    public void testSetNeighbours_tooFewNeighbours(){
        int value = 1;
        boolean result = true;
        RiddleNode testNode = new RiddleNode(RiddleType.VAL, value, result);

        try {
            testNode.setNeighbours(testNode);
            Assert.assertEquals("no Exception where expecting one...", "test", "fail");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("wrong error", "Each node must have 2, 3 or 4 non-null neighbours - not less!", e.getMessage());
        }
    }

    @Test
    public void testSetNeighbours_neighboursAreNull(){
        int value = 1;
        boolean result = true;
        RiddleNode testNode = new RiddleNode(RiddleType.VAL, value, result);

        try {
            testNode.setNeighbours(null);
            Assert.assertEquals("no Exception where expecting one...", "test", "fail");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("wrong error", "neighbours must not be null!", e.getMessage());
        }
    }

    @Test
    public void testSetNeighbours_tooManyNeighbours(){
        int value = 1;
        boolean result = true;
        RiddleNode testNode = new RiddleNode(RiddleType.VAL, value, result);

        try {
            testNode.setNeighbours(testNode, testNode, testNode, testNode, testNode);
            Assert.assertEquals("no Exception where expecting one...", "test", "fail");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("wrong error", "Each node must have 2, 3 or 4 non-null neighbours - not more!", e.getMessage());
        }
    }


    // ################ Tests 4 RiddleSolver
    @Test
    public void testAllPaths_prettyEmptyAndVisited(){
        int value = 1;
        boolean result = true;
        RiddleNode testNode = new RiddleNode(RiddleType.VAL, value, result);
        testNode.visited = true;
        RiddleNode[][] expected = {};
        RiddleNode[][] res = RiddleSolver.allPaths(testNode, null, expected);
        Assert.assertEquals("empty stuff shouldn't change S", expected.length, res.length);

    }

    @Test
    public void testAllPaths_prettyEmptyAndNotVisited(){
        int value = 1;
        boolean result = true;
        RiddleNode testNode = new RiddleNode(RiddleType.VAL, value, result);
        RiddleNode[] testP = {testNode};
        RiddleNode[][] expected = {testP};
        RiddleNode[][] res = RiddleSolver.allPaths(testNode, testP, new RiddleNode[][]{});
        Assert.assertEquals("expected S to have been changed", expected.length, res.length);
        Assert.assertEquals("expected S to have been changed", expected[0].length+1, res[0].length);

    }

    @Test
    public void testAllPaths_prettyEmptyAndNotVisitedResultFalse_coversAll(){
        int value = 1;
        boolean result = false;
        RiddleNode testNode = new RiddleNode(RiddleType.VAL, value, result);
        testNode.setNeighbours(testNode, testNode);
        RiddleNode[] testP = {testNode};
        RiddleNode[][] expected = {testP};
        RiddleNode[][] res = RiddleSolver.allPaths(testNode, testP, new RiddleNode[][]{});
        Assert.assertEquals("empty stuff shouldn't change S", 0, res.length);
        Assert.assertEquals("empty stuff shouldn't change S", expected[0], testP);

    }

    @Test
    public void testSolve_bullshitMode(){
        int value = 1;
        boolean result = true;
        RiddleNode testNode = new RiddleNode(RiddleType.VAL, value, result);

        RiddleNode[] res = RiddleSolver.solve(testNode);
        Assert.assertEquals("invlid stuff schould end up null", null, res);
    }

    @Test
    public void testSolve_smokeTest(){
        int value = 1;
        boolean result = true;
        RiddleNode testNode = new RiddleNode(RiddleType.ADD, value, result);

        RiddleNode[] solve = RiddleSolver.solve(testNode);
        Assert.assertEquals("invlid stuff schould end up null", null, solve);
    }

    @Test
    public void testIsSolution_coverOPs(){
        int value = 1;
        boolean result = true;
        RiddleType[] riddleTypes = RiddleType.values();
        RiddleNode[] nodes = new RiddleNode[riddleTypes.length*2+1];
        nodes[0] = new RiddleNode(RiddleType.ADD, value, result);
        for (int i = 0; i<riddleTypes.length; i++) {
            nodes[2*i+1] = new RiddleNode(riddleTypes[i], value, result);
            nodes[2*i+2] = new RiddleNode(riddleTypes[i], value, result);
        }

        boolean isSolution = RiddleSolver.isSolution(nodes);
        Assert.assertEquals("bullshit shouldn't be a solution, this ain't politics", false, isSolution);
    }

    @Test
    public void testIsSolution_divFail(){
        int value = 3;
        boolean result = true;
        RiddleType[] riddleTypes = RiddleType.values();
        RiddleNode[] nodes = new RiddleNode[riddleTypes.length*2+1];
        nodes[0] = new RiddleNode(RiddleType.ADD, value, result);
        for (int i = 0; i<riddleTypes.length; i++) {
            nodes[2*i+1] = new RiddleNode(riddleTypes[i], value++, result);
            nodes[2*i+2] = new RiddleNode(riddleTypes[i], value, result);
        }

        boolean isSolution = RiddleSolver.isSolution(nodes);
        Assert.assertEquals("bullshit shouldn't be a solution, this ain't politics", false, isSolution);
    }
    @Test
    public void testIsSolution_eqFail(){
        int value = 3;
        boolean result = true;
        RiddleType[] riddleTypes = RiddleType.values();
        RiddleNode[] nodes = new RiddleNode[riddleTypes.length*2-1];
        int counter = 0;
        nodes[counter++] = new RiddleNode(RiddleType.ADD, value, result);
        for (int i = 0; i<riddleTypes.length; i++) {
            if (RiddleType.DIV == riddleTypes[i]) continue;
            nodes[counter++] = new RiddleNode(riddleTypes[i], value++, result);
            nodes[counter++] = new RiddleNode(riddleTypes[i], value, result);
        }

        boolean isSolution = RiddleSolver.isSolution(nodes);
        Assert.assertEquals("bullshit shouldn't be a solution, this ain't politics", false, isSolution);
    }
    @Test
    public void testIsSolution_happyPath(){
        int value = 12;
        boolean result = true;
        RiddleNode[] nodes = new RiddleNode[3];
        int counter = 0;
        nodes[counter++] = new RiddleNode(RiddleType.VAL, value, result);
        nodes[counter++] = new RiddleNode(RiddleType.EQ, value, result);
        nodes[counter++] = new RiddleNode(RiddleType.EQ, value, result);

        boolean isSolution = RiddleSolver.isSolution(nodes);
        Assert.assertEquals("we should get true for a solution", true, isSolution);
    }
    @Test
    public void testSolve_happyPath(){

        int value = 12;
        boolean result = false;
        RiddleNode[] nodes = new RiddleNode[3];
        int counter = 0;
        nodes[counter++] = new RiddleNode(RiddleType.VAL, value, result);
        nodes[counter++] = new RiddleNode(RiddleType.EQ, value, result);
        nodes[counter++] = new RiddleNode(RiddleType.EQ, value, true);

        nodes[0].setNeighbours(nodes[1], nodes[1]);
        nodes[1].setNeighbours(nodes[2], nodes[2]);
        RiddleNode[] solve = RiddleSolver.solve(nodes[0]);
        Assert.assertEquals("we should get 3 solutions", 3, solve.length);
    }

    @Test
    public void testSolve_notCool(){
        RiddleNode div1 = new RiddleNode(RiddleType.DIV, -1, false);
        RiddleNode val1 = new RiddleNode(RiddleType.VAL, 5, false);
        RiddleNode eq1 = new RiddleNode(RiddleType.EQ, -1, false);
        RiddleNode val2 = new RiddleNode(RiddleType.VAL, 3, false);
        RiddleNode eq2 = new RiddleNode(RiddleType.EQ, -1, false);
        RiddleNode val3 = new RiddleNode(RiddleType.VAL, 3, true);
        val2.setNeighbours(null, eq2, null, div1);
        eq2.setNeighbours(val2, val3, null, val1);
        val3.setNeighbours(eq2, null, null, eq1);

        RiddleNode[] shortestPath = RiddleSolver.solve(val3);
        Assert.assertEquals("we shouldn't get a solution", null, shortestPath);
    }
}
