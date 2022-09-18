package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_39b
   extends TilingType
{
   public TilingTypeNC5_39b(){
      super( "NC5-39b", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 50, 50};
      paramName = new String[]{ "Aspect", "Indentation" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,1,0, 1},
            {1, 4,0, 1,0,4, 1},
            {0, 1,0, 2,2,1, 0},
      };
      info = "c=d=e\nB+C=360\nB=D\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 2. * paramValues[0]/100;   // long side
      double height = 2 - ln2;
      double ln1 = ln2 * paramValues[1]/100;   // teeth edges
      double a = Math.atan2(height/4,ln1)/DEG2RAD;

      double c = Math.cos( a * DEG2RAD);
      double s = Math.sin( a * DEG2RAD);

      double x1 = ln2 * c;
      double y1 = ln2 * s;
      double x2 = (ln2-ln1) * c;
      double y2 = (ln2+ln1) * s;
      double x3 = ln2 * c;
      double y3 = (ln2+ln1*2) * s;
      double x4 = (ln2-ln1) * c;
      double y4 = (ln2+ln1*3) * s;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[1].getX(1);
      offsets[1] = tiles[0].getY(4)-tiles[1].getY(1);
      offsets[2] = tiles[3].getX(4)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(4)-tiles[0].getY(0);
   }
}
