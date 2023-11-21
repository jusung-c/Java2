package Lab7.periodic;

// Phase enum 클래스
public enum Phase {
	gas,
	liq,
	solid,
	artificial;
	
	// String 값과 일치하는 Phase 타입 반환
	public static Phase names(String input) {
		for(Phase p : Phase.values()) {
			if (p.toString().equals(input)) {
				return p;
			}
		}

		// 일치하는 phase가 없으면 null 반환
		return null;
	}
}
