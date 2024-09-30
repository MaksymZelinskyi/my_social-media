import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserInListComponent } from './user-in-list.component';

describe('UserInListComponent', () => {
  let component: UserInListComponent;
  let fixture: ComponentFixture<UserInListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UserInListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserInListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
