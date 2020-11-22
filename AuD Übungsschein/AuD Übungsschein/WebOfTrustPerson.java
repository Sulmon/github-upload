import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class WebOfTrustPerson  extends AbstractWebOfTrustPerson{
    /**
     * Creates and names a new person.
     *
     * @param name the name of the new person
     */
    protected WebOfTrustPerson(String name) {
        super(name);
    }

    @Override
    public void trusts(AbstractWebOfTrustPerson other) {
        this.trusteds.add(other);
    }

    @Override
    public ArrayList<AbstractWebOfTrustPerson> findShortestTrustPathTo(AbstractWebOfTrustPerson other) {
        HashSet<AbstractWebOfTrustPerson> trustedGuys = new HashSet<>();
        ArrayList<AbstractWebOfTrustPerson> path = new ArrayList<>();
        path.add(this);

        Stack<AbstractWebOfTrustPerson> stack = new Stack<>();
        AbstractWebOfTrustPerson currentDude = this;
        while (!stack.isEmpty() || currentDude != null){
            if (currentDude!= null){
                boolean insertedSomething = false;
                for (AbstractWebOfTrustPerson trusted : currentDude.trusteds) {
                    if (trustedGuys.add(trusted) && !stack.contains(trusted)){
                        stack.push(trusted);
                        path.add(trusted);
                        if (trusted.equals(other)){
                            return path;
                        }
                        currentDude = trusted;
                        insertedSomething = true;
                    }
                }
                if (!insertedSomething){

                    path.remove(currentDude);
                    currentDude=null;
                }
            } else {
                currentDude = stack.pop();
            }
        }

        return null;
    }

    @Override
    public HashSet<AbstractWebOfTrustPerson> getAllTrusteds() {
        HashSet<AbstractWebOfTrustPerson> trustedGuys = new HashSet<>();
        Stack<AbstractWebOfTrustPerson> stack = new Stack<>();
        AbstractWebOfTrustPerson currentDude = this;
        while (!stack.isEmpty() || currentDude != null){
            if (currentDude!= null){
                boolean insertedSomething = false;
                for (AbstractWebOfTrustPerson trusted : currentDude.trusteds) {
                    if (trustedGuys.add(trusted) && !stack.contains(trusted)){
                        stack.push(trusted);
                        currentDude = trusted;
                        insertedSomething = true;
                    }
                }
                if (!insertedSomething){
                    currentDude=null;
                }
            } else {
                currentDude = stack.pop();
            }
        }
        trustedGuys.add(this);
        return trustedGuys;
    }

    @Override
    public HashSet<AbstractWebOfTrustPerson> calculateStrongSubset() {
        HashSet<AbstractWebOfTrustPerson> trustedGuys = new HashSet<>();
        Stack<AbstractWebOfTrustPerson> stack = new Stack<>();
        AbstractWebOfTrustPerson currentDude = this;
        while (!stack.isEmpty() || currentDude != null){
            if (currentDude!= null){
                boolean insertedSomething = false;
                for (AbstractWebOfTrustPerson trusted : currentDude.trusteds) {
                    if (trustedGuys.add(trusted) && !stack.contains(trusted)){
                        if (trusted.trusteds.contains(currentDude)){
                            stack.push(trusted);
                            currentDude = trusted;
                            insertedSomething = true;
                        } else {
                            trustedGuys.remove(trusted);
                        }
                    }
                }
                if (!insertedSomething){
                    currentDude=null;
                }
            } else {
                currentDude = stack.pop();
            }
        }
        trustedGuys.add(this);
        return trustedGuys;
    }
}
