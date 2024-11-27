import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FdProcessComponent } from './fd-process.component';

describe('FdProcessComponent', () => {
  let component: FdProcessComponent;
  let fixture: ComponentFixture<FdProcessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FdProcessComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FdProcessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
