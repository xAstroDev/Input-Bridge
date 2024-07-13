package com.catfixture.inputbridge.core.input.utils;

import android.view.MotionEvent;
import com.catfixture.inputbridge.core.input.utils.IDraggable;
import com.catfixture.inputbridge.core.input.utils.ITouchable;
import com.catfixture.inputbridge.core.input.utils.ITransformable;
import com.catfixture.inputbridge.core.utils.math.Int2;
import com.catfixture.inputbridge.core.utils.types.Event;
import java.util.Observable;

public class DragAndDropHandle<T extends ITouchable & ITransformable & IDraggable> {
    private Int2 elementStartPos;
    private boolean isDragging;
    private int limitX = -1;
    private int limitY = -1;
    public Event onDragged = new Event();
    public Event onPositionChanged = new Event();
    private boolean snappingOn;
    private int snappingSize;
    private Int2 startPosition;

    public DragAndDropHandle(T t) {
        t.OnDown().addObserver(new DragAndDropHandle$$ExternalSyntheticLambda0(this, t));
        t.OnMove().addObserver(new DragAndDropHandle$$ExternalSyntheticLambda1(this, t));
        t.OnUp().addObserver(new DragAndDropHandle$$ExternalSyntheticLambda2(this, t));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-catfixture-inputbridge-core-input-utils-DragAndDropHandle  reason: not valid java name */
    public /* synthetic */ void m89lambda$new$0$comcatfixtureinputbridgecoreinpututilsDragAndDropHandle(ITouchable iTouchable, Observable observable, Object obj) {
        this.startPosition = GetPointerCoords((MotionEvent) obj);
        this.elementStartPos = ((ITransformable) iTouchable).GetPosition();
        this.isDragging = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$1$com-catfixture-inputbridge-core-input-utils-DragAndDropHandle  reason: not valid java name */
    public /* synthetic */ void m90lambda$new$1$comcatfixtureinputbridgecoreinpututilsDragAndDropHandle(ITouchable iTouchable, Observable observable, Object obj) {
        if (this.isDragging) {
            Int2 Add = this.elementStartPos.Add(GetPointerCoords((MotionEvent) obj).Sub(this.startPosition));
            if (this.snappingOn && this.snappingSize > 0) {
                Add.x -= Add.x % this.snappingSize;
                Add.y -= Add.y % this.snappingSize;
            }
            if (!(this.limitX == -1 && this.limitY == -1)) {
                ITransformable iTransformable = (ITransformable) iTouchable;
                Add.x = Math.min(Math.max(Add.x, 0), this.limitX - iTransformable.GetSize().x);
                Add.y = Math.min(Math.max(Add.y, 0), this.limitY - iTransformable.GetSize().y);
            }
            ((ITransformable) iTouchable).SetPosition(Add.x, Add.y);
            this.onDragged.notifyObservers(Add);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$2$com-catfixture-inputbridge-core-input-utils-DragAndDropHandle  reason: not valid java name */
    public /* synthetic */ void m91lambda$new$2$comcatfixtureinputbridgecoreinpututilsDragAndDropHandle(ITouchable iTouchable, Observable observable, Object obj) {
        this.isDragging = false;
        this.onPositionChanged.notifyObservers(((ITransformable) iTouchable).GetPosition());
    }

    private Int2 GetPointerCoords(MotionEvent motionEvent) {
        return new Int2((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    public void EnableSnap(int i) {
        this.snappingOn = true;
        this.snappingSize = i;
    }

    public void SetLimits(int i, int i2) {
        this.limitX = i;
        this.limitY = i2;
    }
}
