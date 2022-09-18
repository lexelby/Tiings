package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_48
   extends TilingType
{
   public TilingTypeNC6_48(){
      super( "NC6-48", 6, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{360,100};
      paramDef = new int[]{ 70, 60};
      paramName = new String[]{"Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {0, 0,5, 0,5,0, 0},
            {1, 0,1, 2,0,1, 1},
      };
      info = "a=d=f\nc=e\n2A+F=360\nC+D=360\nA+B+C=360\n(D+E+F=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 1.2;
      double ln1 = lntotal * getParam(paramValues, 1)/100;
      double ln2 = lntotal - ln1;
      double a = getParam(paramValues, 0);
      double f = 180-a/2;

      double c = ln1 * Math.cos(f * DEG2RAD);
      double s = ln1 * Math.sin(f * DEG2RAD);

      baseTile.setPoint(0,         0,     0);
      baseTile.setPoint(1,       ln2,     0);
      baseTile.setPoint(2, (ln2-c)/2,   s/2);
      baseTile.setPoint(3, (ln2+c)/2, 3*s/2);
      baseTile.setPoint(4,         0,   2*s);
      baseTile.setPoint(5,         c,     s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[2].getX(4);
      offsets[1] = tiles[0].getY(3)-tiles[2].getY(4);
      offsets[2] = tiles[3].getX(2)-tiles[1].getX(3);
      offsets[3] = tiles[3].getY(2)-tiles[1].getY(3);
   }
}