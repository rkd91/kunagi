package scrum.server.journal;

import ilarkesto.base.AFactoryCache;
import ilarkesto.base.Cache;
import ilarkesto.base.time.DateAndTime;
import ilarkesto.fp.Predicate;
import ilarkesto.persistence.AEntity;

import java.util.Set;

import scrum.server.admin.User;

public class ChangeDao extends GChangeDao {

	@Override
	public void clearCaches() {
		super.clearCaches();
		changesByParentIdCache.clear();
	}

	public Change postChange(AEntity parent, User user, String key, String value) {
		Change change = newEntityInstance();
		change.setDateAndTime(DateAndTime.now());
		change.setParent(parent);
		change.setUser(user);
		change.setKey(key);
		change.setValue(value);
		saveEntity(change);
		return change;
	}

	private Cache<String, Set<Change>> changesByParentIdCache = new AFactoryCache<String, Set<Change>>() {

		public Set<Change> create(final String parentId) {
			return getEntities(new Predicate<Change>() {

				public boolean test(Change e) {
					return e.getParent().getId().equals(parentId);
				}
			});
		}

	};

	public Set<Change> getChangesByParentId(final String parentId) {
		return changesByParentIdCache.get(parentId);
	}
}