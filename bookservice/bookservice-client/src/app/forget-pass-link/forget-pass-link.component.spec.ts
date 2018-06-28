import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ForgetPassLinkComponent} from './forget-pass-link.component';

describe('ForgetPassLinkComponent', () => {
    let component: ForgetPassLinkComponent;
    let fixture: ComponentFixture<ForgetPassLinkComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [ForgetPassLinkComponent]
        })
            .compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(ForgetPassLinkComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
