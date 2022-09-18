package tilingTypes.NC5.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_52a
   extends TilingType
{
   public TilingTypeNC5_52a(){
      super( "NC5-52a", 5, SymmetryType.pgg );

      paramMin = new int[]{   0,  0,  0,  0 };
      paramMax = new int[]{  90,100,100,100 };
      paramDef = new int[]{  40, 75, 70, 40 };
      paramName = new String[]{ "Angle", "Skew", "Length", "Indentation" };
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 4,3, 0,3,4, 0},
            {0, 0,4, 0,1,0, 1},
            {0, 4,3, 2,3,4, 1},
      };
      info = "a=b+d\nD+E=360\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double anAOB = paramValues[0];
      double minlnOA = 2 * Math.cos(anAOB * DEG2RAD);
      minlnOA = 2/(minlnOA+1);
      double lnOB = (2-minlnOA) * paramValues[1]/100.;
      double lnOA = 2-lnOB;
      double lnAB = calcSide(lnOA, lnOB, anAOB);
      double lnAE = lnAB;
      double lnBC = lnOB*paramValues[2]/100.;
      double anEAB = calcAngle(lnOA, lnAB, lnOB);
      double anABC = 180-anEAB-anAOB;

      double maxindent =  Math.sin(anABC*DEG2RAD) * lnBC / Math.sin(anEAB*DEG2RAD);
      double lnCD = maxindent*paramValues[3]/100.;
      lnAE += lnCD;

      double f = 3/(lnAE+lnAB+lnBC+lnCD);
      lnAE *=f;
      lnAB *=f;
      lnBC *=f;
      lnCD *=f;
      
      double xA = 0;
      double yA = 0;
      double xB = lnAB * Math.cos( (90-anAOB/2-anEAB) * DEG2RAD);
      double yB = lnAB * Math.sin( (90-anAOB/2-anEAB) * DEG2RAD);
      double xC = xB + lnBC * Math.cos( (90+anAOB/2) * DEG2RAD);
      double yC = yB + lnBC * Math.sin( (90+anAOB/2) * DEG2RAD);
      double xD = xC - lnCD * Math.cos( (90-anAOB/2) * DEG2RAD);
      double yD = yC - lnCD * Math.sin( (90-anAOB/2) * DEG2RAD);
      double xE = lnAE * Math.cos( (90-anAOB/2) * DEG2RAD);
      double yE = lnAE * Math.sin( (90-anAOB/2) * DEG2RAD);

      baseTile.setPoint(0, xA, yA);
      baseTile.setPoint(1, xB, yB);
      baseTile.setPoint(2, xC, yC);
      baseTile.setPoint(3, xD, yD);
      baseTile.setPoint(4, xE, yE);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[1].getX(1);
      offsets[1] = tiles[3].getY(0)-tiles[1].getY(1);
      offsets[2] = tiles[0].getX(1)-tiles[1].getX(2);
      offsets[3] = tiles[0].getY(1)-tiles[1].getY(2);
   }
}
