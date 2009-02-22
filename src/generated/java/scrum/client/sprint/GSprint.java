









// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.gen.GwtEntityGenerator










package scrum.client.sprint;

import java.util.*;
import ilarkesto.auth.*;
import ilarkesto.logging.*;
import ilarkesto.base.time.*;
import ilarkesto.base.*;
import ilarkesto.persistence.*;

public abstract class GSprint
            extends scrum.client.common.AGwtEntity {

    public GSprint() {
    }

    public GSprint(Map data) {
        super(data);
        updateProperties(data);
    }

    public static final String ENTITY_TYPE = "sprint";

    @Override
    public final String getEntityType() {
        return ENTITY_TYPE;
    }

    // --- begin ---

    private scrum.client.common.Date begin ;

    public final scrum.client.common.Date getBegin() {
        return this.begin ;
    }

    public final Sprint setBegin(scrum.client.common.Date begin) {
        this.begin = begin ;
        propertyChanged("begin", this.begin);
        return (Sprint)this;
    }

    public final boolean isBegin(scrum.client.common.Date begin) {
        return equals(this.begin, begin);
    }

    // --- goal ---

    private java.lang.String goal ;

    public final java.lang.String getGoal() {
        return this.goal ;
    }

    public final Sprint setGoal(java.lang.String goal) {
        this.goal = goal ;
        propertyChanged("goal", this.goal);
        return (Sprint)this;
    }

    public final boolean isGoal(java.lang.String goal) {
        return equals(this.goal, goal);
    }

    // --- label ---

    private java.lang.String label ;

    public final java.lang.String getLabel() {
        return this.label ;
    }

    public final Sprint setLabel(java.lang.String label) {
        this.label = label ;
        propertyChanged("label", this.label);
        return (Sprint)this;
    }

    public final boolean isLabel(java.lang.String label) {
        return equals(this.label, label);
    }

    // --- end ---

    private scrum.client.common.Date end ;

    public final scrum.client.common.Date getEnd() {
        return this.end ;
    }

    public final Sprint setEnd(scrum.client.common.Date end) {
        this.end = end ;
        propertyChanged("end", this.end);
        return (Sprint)this;
    }

    public final boolean isEnd(scrum.client.common.Date end) {
        return equals(this.end, end);
    }

    // --- project ---

    private String projectId;

    public final scrum.client.project.Project getProject() {
        if (projectId == null) return null;
        return getDao().getProject(this.projectId);
    }

    public final Sprint setProject(scrum.client.project.Project project) {
        String id = project == null ? null : project.getId();
        if (equals(this.projectId, id)) return (Sprint) this;
        this.projectId = id;
        propertyChanged("projectId", this.projectId);
        return (Sprint)this;
    }

    public final boolean isProject(scrum.client.project.Project project) {
        return equals(this.projectId, project);
    }

    // --- update properties by map ---

    public void updateProperties(Map props) {
        String beginAsString = (String) props.get("begin");
        begin  =  beginAsString == null ? null : new scrum.client.common.Date(beginAsString);
        goal  = (java.lang.String) props.get("goal");
        label  = (java.lang.String) props.get("label");
        String endAsString = (String) props.get("end");
        end  =  endAsString == null ? null : new scrum.client.common.Date(endAsString);
        projectId = (String) props.get("projectId");
    }

    @Override
    public void storeProperties(Map properties) {
        super.storeProperties(properties);
        properties.put("begin", this.begin == null ? null : this.begin.toString());
        properties.put("goal", this.goal);
        properties.put("label", this.label);
        properties.put("end", this.end == null ? null : this.end.toString());
        properties.put("projectId", this.projectId);
    }

}
