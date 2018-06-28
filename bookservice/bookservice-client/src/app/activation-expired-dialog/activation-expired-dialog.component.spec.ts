import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ActivationExpiredDialogComponent} from './activation-expired-dialog.component';

describe('ActivationExpiredDialogComponent', () => {
    let component: ActivationExpiredDialogComponent;
    let fixture: ComponentFixture<ActivationExpiredDialogComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [ActivationExpiredDialogComponent]
        })
            .compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(ActivationExpiredDialogComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
