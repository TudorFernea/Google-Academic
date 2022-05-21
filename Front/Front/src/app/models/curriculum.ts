export interface Disciplines{
    id: number;
    name: string;
    optional: boolean;
}
export interface Curriculum {
    id: number;
    disciplines: Disciplines[];
    yearOfStudy: number;

}