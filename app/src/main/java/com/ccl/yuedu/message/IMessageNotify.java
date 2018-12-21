package com.ccl.yuedu.message;

import java.util.List;

public interface IMessageNotify {
	void onNotify(CustomMessage type, List<Object> args);
}
