package statistics.matcher;

import java.util.ArrayList;

public class QueryBuilder {
    ArrayList<Matcher> matchers;

    public QueryBuilder() {
        this.matchers = new ArrayList<>();
    }

    public Matcher build() {
        if (matchers.isEmpty()) {
            return new All();
        }
        Matcher matcher = new And(matchers.toArray(new Matcher[matchers.size()]));
        matchers.clear();
        return matcher;
    }

    public QueryBuilder playsIn(String team) {
        this.matchers.add(new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String fieldName) {
        this.matchers.add(new HasAtLeast(value, fieldName));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String fieldName) {
        this.matchers.add(new HasFewerThan(value, fieldName));
        return this;
    }

    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        this.matchers.add(new Or(m1, m2));
        return this;
    }

    public QueryBuilder not(Matcher matcher) {
        this.matchers.add(new Not(matcher));
        return this;
    }


}
