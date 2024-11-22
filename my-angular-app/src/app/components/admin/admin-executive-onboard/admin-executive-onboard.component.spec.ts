import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminExecutiveOnboardComponent } from './admin-executive-onboard.component';

describe('AdminExecutiveOnboardComponent', () => {
  let component: AdminExecutiveOnboardComponent;
  let fixture: ComponentFixture<AdminExecutiveOnboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdminExecutiveOnboardComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminExecutiveOnboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
