
package com.nuance.shark.hacks.demo.common;

import java.util.Collection;
import java.util.Map;

/**
 * Validator class has methods for validating the variables of types String,
 * Object, StringBuilder, Collection Map, Integer, Float and also Arrays.
 * Methods are for validation whether variable is Empty or Integer or Float.
 *
 */
public final class Validator {
	/**
	 * This class should not be instantiated.
	 */
	private Validator() {
	}

	/**
	 * Returns <code>true</code> if the <code>Object</code> is <code>null</code> or
	 * the <code>toString()</code> method of the object returns an empty string.
	 *
	 * @param obj the object to be tested on.
	 * @return <code>true</code> if the <code>Object</code> is <code>null</code> or
	 *         the <code>toString()</code> method of the object returns an empty
	 *         string.
	 */
	public static boolean isEmpty(Object obj) {
		if (obj instanceof String) {
			return isEmptyStr((String) obj);
		}

		if (obj instanceof Map<?, ?>) {
			return isEmptyMap((Map<?, ?>) obj);
		}

		if (obj instanceof Collection<?>) {
			return isEmptyCollection((Collection<?>) obj);
		}

		if (obj instanceof StringBuilder) {
			return isEmptyStrBld((StringBuilder) obj);
		}

		if (obj instanceof Object[]) {
			return isEmptyArr((Object[]) obj); // NOSONAR
		}

		return ((obj == null) || (obj.toString() == null) || (obj.toString().trim().length() == 0));
	}

	/**
	 * Answers whether the passed in object is considered to have a value
	 *
	 * @param obj
	 * @return
	 */
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}

	/**
	 * Returns <code>true</code> if the <code>strArray</code> is <code>null</code>
	 * or empty.
	 *
	 * @param strArray the string array to be tested on.
	 * @return <code>true</code> if the <code>strArray</code> is <code>null</code>
	 *         or empty. Otherwise returns <code>false</code>.
	 */
	public static <T> boolean isEmptyArr(T[] array) {
		return ((array == null) || (array.length == 0));
	}

	public static <T> boolean isNotEmptyArr(T[] array) {
		return !isEmptyArr(array);
	}

	/**
	 * Returns <code>true</code> if the <code>String</code> is <code>null</code> ,
	 * an empty string, or contains only empty spaces.
	 *
	 * @param str the string to be tested on.
	 * @return <code>true</code> if the <code>String</code> is <code>null</code> ,
	 *         an empty string, or contains only empty spaces. Otherwise returns
	 *         <code>false</code>.
	 */

	public static boolean isEmptyStr(String str) {
		return str == null || str.isEmpty();
	}

	public static boolean isNotEmptyStr(String str) {
		return !isEmptyStr(str);
	}

	/**
	 * Returns <code>true</code> if the <code>StringBuilder</code> is
	 * <code>null</code>, represents an empty string or an string with only empty
	 * spaces.
	 *
	 * @param sb the StringBuilder to be tested on.
	 * @return <code>true</code> if the <code>StringBuilder</code> is
	 *         <code>null</code> or contains an empty string or an string with only
	 *         empty spaces. Otherwise returns <code>false</code>.
	 */
	public static boolean isEmptyStrBld(StringBuilder sb) {
		return ((sb == null) || isEmptyStr(sb.toString()));
	}

	/**
	 * Returns <code>true</code> if the <code>Collection</code> is <code>null</code>
	 * or empty.
	 *
	 * @param collection the <code>Collection</code> to be tested on.
	 * @return <code>true</code> if the <code>Collection</code> is <code>null</code>
	 *         or empty. Otherwise returns <code>false</code>.
	 */
	public static boolean isEmptyCollection(Collection<?> collection) {
		return ((collection == null) || (collection.isEmpty()));
	}

	/**
	 * Returns <code>true</code> if the <code>Collection</code> has values.
	 *
	 * @param collection the <code>Collection</code> to be tested on.
	 * @return <code>true</code> if the <code>Collection</code> has values, false
	 *         otherwise. Otherwise returns <code>false</code>.
	 */
	public static boolean isNotEmpty(Collection<?> collection) {
		return !isEmptyCollection(collection);
	}

	/**
	 * Returns <code>true</code> if the <code>Map</code> is <code>null</code> or
	 * empty.
	 *
	 * @param map the <code>Map</code> to be tested on.
	 * @return <code>true</code> if the <code>Map</code> is <code>null</code> or
	 *         empty. Otherwise returns <code>false</code>.
	 */
	public static boolean isEmptyMap(Map<?, ?> map) {
		return ((map == null) || map.isEmpty());
	}

	public static boolean isNotEmptyMap(Map<?, ?> map) {
		return !isEmptyMap(map);
	}

	/**
	 * Returns <code>true</code> if the given string can be parsed into an integer.
	 *
	 * @param str the <code>String</code> to be tested on.
	 * @return Returns <code>true</code> if the given string can be parsed into an
	 *         integer. Returns <code>false</code> otherwise, or if the string is
	 *         null or empty.
	 */
	public static boolean isInt(String str) {
		if ((str != null) && (str.length() != 0)) {
			try {
				Integer.parseInt(str);
			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

	/**
	 * Returns <code>true</code> if the given string can be parsed into a float.
	 *
	 * @param str the <code>String</code> to be tested on.
	 * @return Returns <code>true</code> if the given string can be parsed into a
	 *         float. Returns <code>false</code> otherwise, or if the string is null
	 *         or empty.
	 */
	public static boolean isFloat(String str) {
		if (str == null) {
			return false;
		}

		try {
			Float.parseFloat(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * @param o1
	 * @param o2
	 * @return
	 */
	public static boolean isEqualValue(Double o1, Double o2) {
		if (o1 != null && o2 != null) {
			if (o1.doubleValue() != o2.doubleValue()) {
				return false;
			}
		} else {
			if (o1 != null || o2 != null) {
				return false;
			}
		}

		return true;
	}

	/**
	 * @param o1
	 * @param o2
	 * @return
	 */
	public static boolean isNotEqualValue(Double o1, Double o2) {
		return !isEqualValue(o1, o2);
	}

	/**
	 * @param o1
	 * @param o2
	 * @return
	 */
	public static boolean isEqualValue(Integer o1, Integer o2) {
		if (o1 != null && o2 != null) {
			if (o1.intValue() != o2.intValue()) {
				return false;
			}
		} else {
			if (o1 != null || o2 != null) {
				return false;
			}
		}

		return true;
	}

	/**
	 * @param o1
	 * @param o2
	 * @return
	 */
	public static boolean isNotEqualValue(Integer o1, Integer o2) {
		return !isEqualValue(o1, o2);
	}

	/**
	 * @param o1
	 * @param o2
	 * @return
	 */
	public static <T> boolean isEqualValue(T o1, T o2) {
		if (o1 != null && o2 != null) {
			if (!o1.equals(o2)) {
				return false;
			}
		} else {
			if (o1 != null || o2 != null) {
				return false;
			}
		}

		return true;
	}

	/**
	 * @param o1
	 * @param o2
	 * @return
	 */
	public static <T> boolean isNotEqualValue(T o1, T o2) {
		return !isEqualValue(o1, o2);
	}

}
