import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Loggout } from './logout';

describe('Loggout', () => {
  let component: Loggout;
  let fixture: ComponentFixture<Loggout>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Loggout],
    }).compileComponents();

    fixture = TestBed.createComponent(Loggout);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
