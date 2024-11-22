import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerPageComponent } from './customer-page.component';

describe('CustomerPageComponent', () => {
  let component: CustomerPageComponent;
  let fixture: ComponentFixture<CustomerPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CustomerPageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
