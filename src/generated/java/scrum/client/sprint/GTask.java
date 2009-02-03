









// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.gen.GwtEntityGenerator










package scrum.client.sprint;

import java.util.*;

public abstract class GTask
            extends scrum.client.common.AGwtEntity {

    public GTask() {
    }

    public GTask(Map data) {
        super(data);
        updateProperties(data);
    }

    public static final String ENTITY_TYPE = "task";

    @Override
    public final String getEntityType() {
        return ENTITY_TYPE;
    }

    // --- requirement ---

    private String requirementId;

    public final scrum.client.project.Requirement getRequirement() {
        if (requirementId == null) return null;
        return getDao().getRequirement(this.requirementId);
    }

    public final Task setRequirement(scrum.client.project.Requirement requirement) {
        String id = requirement == null ? null : requirement.getId();
        if (equals(this.requirementId, id)) return (Task) this;
        this.requirementId = id;
        propertyChanged("requirementId", this.requirementId);
        return (Task)this;
    }

    public final boolean isRequirement(scrum.client.project.Requirement requirement) {
        return equals(this.requirementId, requirement);
    }

    // --- label ---

    private java.lang.String label ;

    public final java.lang.String getLabel() {
        return this.label ;
    }

    public final Task setLabel(java.lang.String label) {
        this.label = label ;
        propertyChanged("label", this.label);
        return (Task)this;
    }

    public final boolean isLabel(java.lang.String label) {
        return equals(this.label, label);
    }

    // --- remainingWork ---

    private java.lang.Integer remainingWork ;

    public final java.lang.Integer getRemainingWork() {
        return this.remainingWork ;
    }

    public final Task setRemainingWork(java.lang.Integer remainingWork) {
        this.remainingWork = remainingWork ;
        propertyChanged("remainingWork", this.remainingWork);
        return (Task)this;
    }

    public final boolean isRemainingWork(java.lang.Integer remainingWork) {
        return equals(this.remainingWork, remainingWork);
    }

    // --- notice ---

    private java.lang.String notice ;

    public final java.lang.String getNotice() {
        return this.notice ;
    }

    public final Task setNotice(java.lang.String notice) {
        this.notice = notice ;
        propertyChanged("notice", this.notice);
        return (Task)this;
    }

    public final boolean isNotice(java.lang.String notice) {
        return equals(this.notice, notice);
    }

    // --- burnedWork ---

    private int burnedWork ;

    public final int getBurnedWork() {
        return this.burnedWork ;
    }

    public final Task setBurnedWork(int burnedWork) {
        this.burnedWork = burnedWork ;
        propertyChanged("burnedWork", this.burnedWork);
        return (Task)this;
    }

    public final boolean isBurnedWork(int burnedWork) {
        return equals(this.burnedWork, burnedWork);
    }

    // --- update properties by map ---

    public void updateProperties(Map props) {
        requirementId = (String) props.get("requirementId");
        label  = (java.lang.String) props.get("label");
        remainingWork  = (java.lang.Integer) props.get("remainingWork");
        notice  = (java.lang.String) props.get("notice");
        burnedWork  = (Integer) props.get("burnedWork");
    }

    @Override
    public void storeProperties(Map properties) {
        super.storeProperties(properties);
        properties.put("requirementId", this.requirementId);
        properties.put("label", this.label);
        properties.put("remainingWork", this.remainingWork);
        properties.put("notice", this.notice);
        properties.put("burnedWork", this.burnedWork);
    }

}
