export interface Disciplines{
    id: number;
    name: string;
    optional: boolean;
    credits: number;
    teacherName: string;
    curriculum: Curriculum;
}

export interface Curriculum {
    id: number;
    text: string;
}
export interface YearOfStudy{
    id: number;
    year: number;
    specializationName: string;
}

export interface Grade{
    id: number,
    studentId: number,
    disciplineId: number,
    value: number
}
export interface Student{
    id: number,
    firstName: string,
    lastName: string,
    group: string
}